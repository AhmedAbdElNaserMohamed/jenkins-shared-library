#!/usr/bin/env groovy
def call () {
    echo "Building the docker image"
    sh 'mvn package'
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')])
    sh 'docker built -t ahmedabdelnasermohamed2/my-repo:jma-2.0 .'
    sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
    sh 'docker push ahmedabdelnasermohamed2/demo-app:jma-2.0'
}