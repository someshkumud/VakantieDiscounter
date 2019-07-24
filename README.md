# DemoCaspar

<B>Automation task:</B>

Please setup an automated test case for the following user flow:
1) Navigate to “ https://beta.caspar-health.com/en/#/user/sign_in ”
2) Login with the following user credentials: Caspar ID: IXE0865 password: 78350619
3) Click “Add patient” and create a new patient
4) Use the login credentials of the patient
5) Logout the user
6) Login as the new patient on the same url like provided in step 1
7) Check that the t&c and release of medical information page is displayed. You don’t have
to continue further with the login steps.

<B>Pre-requisites:</B>
1. Download and configure JDK1.8 in system(including environment variables)
2. Download and configure Maven in system(including environment variables)
2. Pull/create copy of project in local drive

<B>Steps to Execute:</B>
1. Open command prompt
2. Navigate to project folder
3. Run command "mvn clean compile verify" - This wil start execution
4. After execution  completion report will be genetated : "<Project Folder>\target\cucumber-report-html\cucumber-html-reports\overview-features.html"
# VakantieDiscounter
