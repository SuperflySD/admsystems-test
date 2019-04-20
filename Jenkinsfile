
node {
    stage("checkout") {
        checkout scm
    }
    stage("Test") {
        try {
            sh "chmod +x gradlew"
            sh "./gradlew build"
        }

        catch (err) {
            currentBuild.result = 'FAILURE'
            notifyBuild(currentBuild.result)
            throw err
        }
        finally {
        }
    }



}

def notifyBuild(String buildStatus = 'STARTED') {
    // build status of null means successful
    buildStatus = buildStatus ?: 'SUCCESSFUL'

    final def RECIPIENTS = emailextrecipients(
            [[$class: 'DevelopersRecipientProvider'],
             [$class: 'FailingTestSuspectsRecipientProvider'],
             [$class: 'CulpritsRecipientProvider']
            ])

    final def SUBJECT = "${env.JOB_NAME} ${env.BRANCH_NAME} - Build #${env.BUILD_NUMBER} - $buildStatus!"
    final def CONTENT = "Check console output at ${env.BUILD_URL} to view the results."
    final def JENKINS_ADMINISTRATOR = "serdor@mail.ru"

    mail to: RECIPIENTS,
            replyTo: JENKINS_ADMINISTRATOR,
            subject: SUBJECT,
            body: CONTENT

}

