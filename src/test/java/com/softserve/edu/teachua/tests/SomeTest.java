package com.softserve.edu.teachua.tests;

import com.softserve.edu.teachua.data.*;
import com.softserve.edu.teachua.pages.challenge.ChallengeTeachPage;
import com.softserve.edu.teachua.pages.challenge.YoutubeFrame;
import com.softserve.edu.teachua.pages.club.AdvancedClubPage;
import com.softserve.edu.teachua.pages.club.ClubComponent;
import com.softserve.edu.teachua.pages.club.ClubDetailsPage;
import com.softserve.edu.teachua.pages.club.ClubNotFoundPage;
import com.softserve.edu.teachua.pages.menu.HomePage;
import com.softserve.edu.teachua.pages.top.TopPart;
import com.softserve.edu.teachua.pages.user.LoginModal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Execution(ExecutionMode.CONCURRENT)
public class SomeTest extends TestRunner {

    @Test
    public void checkSmoke() {
        // Steps
        HomePage homePage = loadApplication()
                .gotoClubPage()
                .gotoNewsPage()
                .gotoAboutUsPage()
                .gotoUkrainianServicePage()
                .gotoHomePage();
        presentationSleep();
        //
        // Check
        Assertions.assertTrue(homePage.getTeachLabelText().contains(HomePage.BEGIN_TEACH_LABEL_MESSAGE));
    }

    private static Stream<Arguments> validUserProvider() {
        return Stream.of(
                Arguments.of(UserRepository.get().customer())
        );
    }
    @ParameterizedTest(name = "{index} => email={0}, password={1}")
    //@CsvSource({"yagifij495@eqvox.com, Qwerty_1"})
    //public void checkSuccessfulLogin(String email, String password) {
    @MethodSource("validUserProvider")
    public void checkSuccessfulLogin(IUser user) {
        // Steps
        HomePage homePage = loadApplication()
                .openLoginModal()
                .successfulLogin(user.getEmail(), user.getPassword());
        String popupMessage = homePage.getPopupMessageLabelText();
        presentationSleep();
        //
        // Check pop-up message
        Assertions.assertEquals(TopPart.POPUP_MESSAGE_SUCCESSFULLY, popupMessage);
        //
        // Check
        Assertions.assertTrue(homePage.getTeachLabelText().contains(HomePage.BEGIN_TEACH_LABEL_MESSAGE));
        presentationSleep();
        //
        homePage = homePage.signoutUser();
        Assertions.assertFalse(homePage.isUserLogged());
        presentationSleep();
    }


    private static Stream<Arguments> invalidUserProvider() {
        return Stream.of(
                Arguments.of(UserRepository.get().invalidUser())
        );
    }

    @ParameterizedTest(name = "{index} => email={0}, password={1}")
    @MethodSource("invalidUserProvider")
    public void checkUnsuccessfulLogin(IUser user) {
        // Steps
        LoginModal loginModal = loadApplication()
                .openLoginModal()
                .unsuccessfulLoginPage(user.getEmail(), user.getPassword());
        String popupMessage = loginModal.getPopupMessageLabelText();
        presentationSleep();
        //
        // Check pop-up message
        Assertions.assertEquals(LoginModal.POPUP_MESSAGE_UNSUCCESSFULLY, popupMessage);
        presentationSleep();
    }

    private static Stream<Arguments> challengeTeachProvider() {
        return Stream.of(
                Arguments.of(Challengies.TO_LEARN_CHALLENGE, UrlContents.WEBINAR_IFRAME)
        );
    }

    @ParameterizedTest(name = "{index} => challengeName={0}")
    @MethodSource("challengeTeachProvider")
    public void checkChallenge(Challengies challengeName, UrlContents urlContents) {
        YoutubeFrame youtubeFrame = loadApplication()
                .gotoChallengePage(challengeName, ChallengeTeachPage.class)
                .gotoYoutubeFrame()
                .playVideoContent();
        presentationSleep(4);
        System.out.println("\tyoutubeFrame.getYoutubeLinkText() = " + youtubeFrame.getYoutubeLinkText());
        //
        // Check Youtube Frame
        Assertions.assertTrue(youtubeFrame.getYoutubeLinkText().contains(urlContents.getSearchVideo()));
        presentationSleep();
        //
        HomePage homePage = youtubeFrame
                .gotoChallengeTeachPage()
                .gotoHomePage();
        presentationSleep(4);
    }

    private static Stream<Arguments> cityProvider() {
        return Stream.of(
                Arguments.of(Cities.KYIV_CITY),
                Arguments.of(Cities.HARKIV_CITY)
        );
    }

    @ParameterizedTest(name = "{index} => city={0}")
    @MethodSource("cityProvider")
    public void checkCityClubs(Cities city) {
        ClubComponent ClubComponent = loadApplication()
                .gotoClubPage()
                .chooseCity(city)
                .getClubContainer()
                .getFirstClubComponent();
        //
        // Check first club address
        Assertions.assertTrue(ClubComponent.getAddressLabelText().contains(city.getCity()));
        presentationSleep();
    }


    private static Stream<Arguments> clubProvider() {
        return Stream.of(
                Arguments.of(ClubContents.NEW_CADRE_CLUB),
                Arguments.of(ClubContents.VECTOR_CLUB)
        );
    }

    @ParameterizedTest(name = "{index} => clubContents={0}")
    @MethodSource("clubProvider")
    public void checkClubExist(ClubContents clubContents) {
        ClubComponent ClubComponent = loadApplication()
                .gotoClubPage()
                .chooseCity(clubContents.getCity())
                .getClubContainer()
                .getClubComponentByPartialTitle(clubContents.getTitle());
        //
        // Check club titles and descriptions
        Assertions.assertTrue(ClubComponent.getTitleLinkText().contains(clubContents.getTitle()));
        presentationSleep();
    }

    @ParameterizedTest(name = "{index} => clubContents={0}")
    @MethodSource("clubProvider")
    public void checkAdvancedSearch(ClubContents clubContents) {
        AdvancedClubPage advancedClubPage = loadApplication()
                .gotoClubPage()
                .chooseCity(clubContents.getCity())
                .gotoAdvancedClubPage();
        //
        // Use pagination to search club
        Assertions.assertTrue(advancedClubPage.isExistClubByPartialTitle(clubContents.getTitle()));
        presentationSleep();
    }

    private static Stream<Arguments> commentProvider() {
        return Stream.of(
                Arguments.of(ClubContents.IT_EDUCATION_CLUB, CommentContents.FIRST_COMMENT)
        );
    }

    @ParameterizedTest(name = "{index} => clubContents={0}, commentContents={0}")
    @MethodSource("commentProvider")
    public void checkCommentExist(ClubContents clubContents, CommentContents commentContents) {
        ClubDetailsPage clubDetailsPage = loadApplication()
                .gotoClubPage()
                .chooseCity(clubContents.getCity())
                .getClubContainer()
                .getClubComponentByPartialTitle(clubContents.getTitle())
                .openClubDetailsPage();
        //
        // Check comment exist
        Assertions.assertTrue(clubDetailsPage.getCommentsContainer()
                .isExistClubComponentByPartialAuthor(commentContents.getAuthor()));
        presentationSleep();
    }
}
