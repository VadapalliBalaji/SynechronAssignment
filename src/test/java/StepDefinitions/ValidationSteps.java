package StepDefinitions;

import Pages.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidationSteps {
	private BasePage base;
	public ValidationSteps() {
		base = new BasePage();
	}

	@Given("I navigate to amex home page")
	public void i_navigate_to_amex_home_page() {
		base.invokeBrowser();
	}
	@Then("I validate the title of {string}")
	public void i_validate_the_title_of(String title) {
		base.getTitle(title);
	}
	
	@When("I accept the cookie")
	public void i_accept_the_cookie()
	{
		base.acceptCookie();
	}
	@When("I click on the Cartes Particuliers to get the card details")
	public void i_click_on_the_cartes_particuliers_to_get_the_card_details() {
		base.clickOption();
	}
	@When("I click on En Savior Plus under Cartes Gold American Express")
	public void i_click_on_en_savior_plus_under_cartes_gold_american_express() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("I click on Demandez Votre Carte")
	public void i_click_on_demandez_votre_carte() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("I fill the  Fill junk data")
	public void i_fill_the_fill_junk_data() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("I click on Sauvegarder et Continuer")
	public void i_click_on_sauvegarder_et_continuer() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}