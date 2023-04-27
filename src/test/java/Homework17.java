import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 {

    @Test
    public void addSongToPlaylist() {

        // Pre-condition, Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments ("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Navigate to "https://bbb.testpro.io/"
        String url = "https://bbb.testpro.io";
        driver.get(url);
        //Log in with your credentials
        WebElement emailAddress = driver.findElement(By.cssSelector("[type='email']"));
        emailAddress.click();
        emailAddress.sendKeys("demo@class.com");

        WebElement password = driver.findElement(By.cssSelector("[type='password']"));
        password.click();
        password.sendKeys("test$tudent");

        //Search for a song (choose any song of your choice)
        WebElement searchForSongs = driver.findElement(By.cssSelector("[type='search']"));
        searchForSongs.click();
        searchForSongs.sendKeys("Take my Hand");

        //Click View All to display the search results
        WebElement viewAll = driver.findElement(By.cssSelector("[class='panes']"));
        viewAll.click();
        //Click the first song in the search results
        WebElement clickFirstSong = driver.findElement(By.cssSelector("[class='song.item selected'] > [class='title']")); //???
        clickFirstSong.click();
        //Click ADD TO...
        WebElement buttonAddTo = driver.findElement(By.cssSelector("[[class='btn-add-to']]"));
        buttonAddTo.click();
        //Choose the playlist to add it to, (we can create a new one with a unique name)
        WebElement choosePlaylistToAddTo = driver.findElement(By.cssSelector("div [data-test='add-to-menu'] [class='favorites']")); //??
        choosePlaylistToAddTo.click();
        //Verify that the notification message appears
        Assert.assertTrue(userAvatar.isDisplayded);
        //Verify that notification message has the text, "Added 1 song into {your playlist}"

        //
    }

}
