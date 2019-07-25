# DemoVakantieDiscounter
<B>Automation task:</B>
Smoke Test Dé VakantieDiscounter

<B>Introduction</B>
Dé VakantieDiscoutner website (https://www.vakantiediscounter.nl) is a place where our
customers can purchase holiday packages. Holiday packages are travel products that combine
a flight, a transfer, and a hotel packed together for one price. It is a travel product that focuses
on service and allows peace of mind for our customers. Dé VakantieDiscoutner is currently
the largest Online Travel Agent in The Netherlands and allows our customers to compare
holiday packages from different Tour Operators.

Our customers typically go through a number of phases before they buy the product. There
is an orientation phase to determine where and how they want to spend their holiday. Then
they select the specific accommodation and after which they purchase the holiday package.
All three phases are facilitated by our website and it is of course important that these always
work.

<B>The Assessment</B>

The assessment consists of automating the happy flow customer journey on our website. It
should potentially be possible to add your solution to our CI/CD pipeline.

<B>Step 1</B>
- Start on the Homepage (https://www.vakantiediscounter.nl)
- Select the Sun Vertical

<B>Step 2</B>
- On the Sun Vertical page (https://www.vakantiediscounter.nl/zonvakantie)
- Select:
o Destination: Spanje
o Date: 3 - 4 month in the future
o Duration: 11-16 dagen
o Travel party: 2 personen
- Continue to the Search Results page

<B>Step 3</B>
- On the Search Results page make sure that:
o "Incl. vlucht" selected
o Departure airport Amsterdam (Schiphol)
o Board type All inclusive
- And choose the first Accommodation (note that this will look differently for you
since our inventory changes all the time)

<B>Step 4</B>
- Check price (“CONTROLEER PRIJS”)
- Book now (“NU BOEKEN”)
- Remarks: there is a complication in this step of the happy flow. With the check-price
action we actually retrieve the current price and availability of the offer. There is a
change that the offer is not available anymore. This is also the reason to select a
date 3 - 4 month in the future because the availability is higher then. The above
should not break the smoke test. Typically selecting an other departure date
remedies this situation.

<B>Step 5</B>
- Enter Bookflow step 1 and fill in the travelers details:
o Volwassene 1:
    § Aanhef: de heer
    § Voornaam: Jan
    § Achternaam: Visser
    § Geboortedatum: 10 Oktober 1972
    § Nationaliteit: Nederlandse
o Volwassene 2:
    § Aanhef: mevrouw
    § Voornaam: Mirjam
    § Achternaam: Visser
    § Geboortedatum: 3 April 1975
    § Nationaliteit: Nederlandse
o Contactgegevens hoofdboeker:
    § Land: Nederland
    § Postcode: 1852TB
    § Huisnummer: 23
    § Straat: Termijen
    § Woonplaats: Heiloo
    § E-mailadres: jan.visser.dummy@gmail.com
    § Telefoonnummer: 0612345678
o Contactpersoon bij calamiteiten
    § Naam: Fam. Visser
    § Telefoonnummer: 0612345687

<B>Step 6</B>
- On the next step of the book flow don’t add any additional products
- Continue to the overview page

<B>Step 7</B>
- On the last step of the book flow check that the final price corresponds to the price
shown when we went into the check-out
- Remark: do not go to "Naar Betalen" since this actually triggers unfinished bookings
in our mid-office system that we act on.
And that is all

========================================================================================

<B>Pre-requisites:</B>
1. Download and configure JDK1.8 in system(including environment variables)
2. Download and configure Maven in system(including environment variables)
2. Pull/create copy of project in local drive

<B>Steps to Execute the test:</B>
1. Open command prompt
2. Navigate to project folder
3. Run command "mvn clean compile verify" - This wil start execution
4. After execution  completion report will be generated : "<Project Folder>\target\cucumber-html-reports\overview-features.html"

<B>NOTE : To add test to Continuous integration just add maven command (mvn clean compile verify) to testing stage of pipeline</B>