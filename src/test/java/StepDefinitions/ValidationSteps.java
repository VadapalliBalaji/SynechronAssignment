package StepDefinitions;
import Pages.BasePage;
import io.cucumber.datatable.DataTable;
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
	@When("I click on the {string}")
	public void i_click_on_the_cartes_particuliers_to_get_the_card_details(String linkType) {
		base.clickOption(linkType);
	}
	
	@When("I fill the form with valid values:")
	public void i_fill_the_form_with_valid_values(DataTable dataTable) {
		base.fillDetails(dataTable);
	}
	

	@Then("I validate the errors messages in UI")
	public void i_validate_the_errors_messages_in_ui(DataTable dataTable) 
	{
		
	}
	}