// Pipline = Must be top-level
pipeline 
{ 
    // Agent = Where to execute "any" 
    agent any 
    // Place to store your variable 
    environmet
    {
        NEW_VERSION = '1.0'
    }
    // Stage = Where the works happens
    stages 
    { 
         // Get the code from github
        stage('GetCodeFromGit') 
        {
            // Condition wen to run the specific code
            // when
            // {
            //     expression
            //     {
            //         BRANCH_NAME == 'master' || CODE_CHANGE == true
            //     }
            // }
            // Steps he need to vollow
            steps 
            {
                echo 'Get the code from git..'
                echo "The version is ${NEW_VERSION}"
            }
        }
        // Checkout the code frome github     
        stage('CheckoutCode') 
        {
            steps 
            {
                echo 'Checking out the code..'
            }
        }
        // Test het code frome github     
        stage('Test') 
        {
            steps
            {
                echo 'Testing the code..'
            }
        }
        // Build the code
        stage('Build') 
        {
            steps 
            {
                echo 'Building the code..'
            }
        }
        // Test by using the Unit test
        stage('UnitTest') 
        {
            steps 
            {
                echo 'UnitTesting...'
            }
        }
        // Notify user
        stage('NotifyUser') 
        {
            steps 
            {
                echo 'notify the user...'
            }
        }
    }
    // After the code ends execute this code
    post
    {
        // Execute always
        // Example message to the user
        always
        {
            echo 'De code is uitgevoerd en de test is klaar'
        }
        // Execut only wen succes
        success
        {
            echo 'Dit is een melding die je alleen krijgt als alles WEL succesvol is'
        }
        // Execute only wen failure
        failure
        {
            echo 'Dit is een melding die je alleen krijgt als alles NIET succesvol is'
        }
    }
}
