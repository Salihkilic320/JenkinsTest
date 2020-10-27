// Pipline = Must be top-level
pipeline { 
    
    // Agent = Where to execute "any" 
    agent any 
   
    // Stage = Where the works happens
    stages { 
         // Get the code from github
        stage('GetCodeFromGit') {
            steps {
                echo 'Get the code from git..'
            }
        }
    
        // Checkout the code frome github     
        stage('CheckoutCode') {
            steps {
                echo 'Checking out the code..'
            }
        }
        
        // Test het code frome github     
        stage('Test') {
            steps {
                echo 'Testing the code..'
            }
        }
    
        // Build the code
        stage('Build') {
            steps {
                echo 'Building the code..'
            }
        }
        
        // Test by using the Unit test
        stage('UnitTest') {
            steps {
                echo 'UnitTesting...'
            }
        }
        
        // Notify user
        stage('NotifyUser') {
            steps {
                echo 'notify the user...'
            }
        }
    }
}
