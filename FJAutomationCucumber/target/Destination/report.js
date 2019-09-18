$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/Resource/Feature/login.feature");
formatter.feature({
  "name": "Check the login flow",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify the login with valid credential",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User should navigate to finance junction URL",
  "keyword": "Given "
});
formatter.match({
  "location": "VerifyLoginScenario.userShouldNavigateToFinanceJunctionURL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should enter valid username and password",
  "keyword": "And "
});
formatter.match({
  "location": "VerifyLoginScenario.userShouldEnterValidUsernameAndPassword()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on Login button",
  "keyword": "When "
});
formatter.match({
  "location": "VerifyLoginScenario.userClickOnLoginButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should login successfully and able to view the Home page",
  "keyword": "Then "
});
formatter.match({
  "location": "VerifyLoginScenario.userShouldLoginSuccessfullyAndAbleToViewTheHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});