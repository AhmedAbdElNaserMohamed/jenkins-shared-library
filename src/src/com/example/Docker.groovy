#!/user/bin/env Groovy
package com.example

class docker implements_serializable {
    def script
    Docker (script){
        this.script = script
    }
    
    def buildingDockerImage(script imageName){    
        script.echo "building the docker image..."
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "docker build -t $imageName ."
            script.sh "echo '${script.PASS}' | docker login -u '${script.USER}' --password-stdin"
            script.sh "docker push $imageName"
    }
    }
    
}