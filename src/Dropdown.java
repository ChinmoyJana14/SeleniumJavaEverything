//This is in C#
/*
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using SeleniumExtras.WaitHelpers;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;

namespace SeleniumPractice
{
    class Program
    {
        static void Main(string[] args)
        {
            IWebDriver driver = new ChromeDriver(@"C:\Softwares"); //<-Add your path
            driver.Navigate().GoToUrl("https://rahulshettyacademy.com/dropdownsPractise/");

            WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(5));

           
            driver.Manage().Window.Maximize();

            //Auto display dropdown
            driver.FindElement(By.Id("autosuggest")).SendKeys("Ind");

            IList<IWebElement> options = wait.Until(ExpectedConditions.VisibilityOfAllElementsLocatedBy(By.CssSelector("li[class='ui-menu-item'] a")));
            var expectedSelection = "INDIA";
            foreach (IWebElement element in options)
            {
                if (element.Text.ToUpper() == expectedSelection.ToUpper())
                {
                    element.Click();
                    break;
                }
            }

            //dropdwon with select tag is a static dropdown where the order never chnge
            var staticDropdown = driver.FindElement(By.CssSelector("Select[id$='DropDownListCurrency']"));
            var selectElement = new SelectElement(staticDropdown);
            selectElement.SelectByIndex(3);
            Console.WriteLine(selectElement.SelectedOption.Text);
            selectElement.SelectByText("AED");
            Console.WriteLine(selectElement.SelectedOption.Text);
            selectElement.SelectByValue("INR");
            Console.WriteLine(selectElement.SelectedOption.Text);

            var paxDropdown = driver.FindElement(By.Id("divpaxinfo"));
            paxDropdown.Click();
            int noOfAdt = 4;
            int i = 1;
            while (i<noOfAdt+1)
            {
                wait.Until(ExpectedConditions.ElementToBeClickable(By.Id("hrefIncAdt"))).Click();
                i++;
            }
            driver.FindElement(By.Id("btnclosepaxoption")).Click();
            Console.WriteLine(paxDropdown.Text);

            //Dynamic dropdown
            driver.FindElement(By.Id("ctl00_mainContent_ddl_originStation1_CTXT")).Click();
            wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("//a[@value='CCU']"))).Click();
           // wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("(//a[@value='MAA'])[2]"))).Click();
            wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath("//div[contains(@id,'destinationStation1')]//a[@value='MAA']"))).Click();
        }
    }
}
*/
