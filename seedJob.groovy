def createMultiBranchJob(jobName, repositoryId, repositoryUrl, viewName) {
    multibranchPipelineJob(jobName) {
        branchSources {
            github {
                id(repositoryId)
                repoOwner('dan-dev-organisation')
                repository(jobName)
                scanCredentialsId('6a7dbc42-805b-4a97-865f-3e884038737b')
            }
        }
    }
}

def buildPipelineJob(repositoryName, repositoryId, repositoryUrl) {
    def viewName = null
    if(repositoryName.startsWith('java-app')) {
        viewName = 'Apis'
        echo 'Is app!'
    }
    
    createMultiBranchJob(repositoryName, repositoryId, repositoryUrl, viewName)
}

buildPipelineJob(repositoryName, repositoryId, repositoryUrl)
