package ScenarioDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class paymentProcessTest {
    static WebDriver driver = WebDriverManager.getDriver();
    @When("user click to the command button")
    public void user_click_to_the_command_button() {
        driver.get("https://www.yousarssif.com/panier?action=show");
        driver.get("https://www.yousarssif.com/commande");
    }

    @And("user complete the payment forms")
     public void user_complete_the_payment_forms() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement phoneElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("shipping_address_phone")));
        phoneElement.sendKeys("20097979");
        driver.findElement(By.id("shipping_address_alias")).sendKeys("Ariana");
        driver.findElement(By.id("shipping_address_firstname")).sendKeys("ranim");
        driver.findElement(By.id("shipping_address_lastname")).sendKeys("mrad");
        driver.findElement(By.id("shipping_address_company")).sendKeys("company");
        driver.findElement(By.id("shipping_address_address1")).sendKeys("address1");
        driver.findElement(By.id("shipping_address_address2")).sendKeys("Sidi Thabet");
        driver.findElement(By.id("shipping_address_city")).sendKeys("Sidi Thabet");
        driver.findElement(By.id("shipping_address_postal_code")).sendKeys("2020");
        driver.findElement(By.id("shipping_address_id_country")).sendKeys("Tunisie");
//        WebElement Mode_de_livraison = driver.findElement(By.id("delivery_option_73"));
//         WebElement Mode_de_livraison = driver.findElement(By.xpath("//input[@type='radio' and @id='delivery_option_73']"));
        WebElement Mode_de_livraison = driver.findElement(By.id("delivery_option_73"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Mode_de_livraison);

        if (!Mode_de_livraison.isSelected()) {
            Mode_de_livraison.click();
            System.out.println("Mode de livraison cochée avec succès.");
        } else {
            System.out.println("Mode de livraison est déjà cochée.");
        }
    }

    @Then("user Choice the payment option")
    public void user_Choice_the_payment_option() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

// Attendre que le DOM soit stable et que le paiement soit visible
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".block-onepagecheckout.block-shipping.loading")));

        WebElement payment_option = driver.findElement(By.id("payment-option-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", payment_option);

        try {
            if (!payment_option.isSelected()) {
                payment_option.click();
                System.out.println("payment option cochée avec succès.");
            } else {
                System.out.println("payment option est déjà cochée.");
            }
        } catch (StaleElementReferenceException e) {
            // Relocaliser l'élément en cas de problème de référence périmée
            System.out.println("Rechargement de l'élément après une exception...");
             payment_option = driver.findElement(By.id("payment-option-1"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", payment_option);
            if (!payment_option.isSelected()) {
                payment_option.click();
                System.out.println("payment option cochée avec succès après rechargement.");
            }
        }


    }

    @Then("click on add to validate commande button")
    public void click_on_add_to_validate_commande_button() {
//        WebElement payment_option = driver.findElement(By.id("payment-option-1"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", payment_option);
//        payment_option.click();

    }


}
