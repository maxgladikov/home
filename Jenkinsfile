pipeline {
        agent any
        tools { gradle '8.2.1'}
        triggers {
                    pollSCM('* * * * *')
                    }

        stages {


                                        stage("Compile config_server") {
                                            steps { 
                                                sh "./gradlew config_server:build"
                                              }
                                        }
                                                          
                                        stage("Unit test config_serve") {
                                            steps { 
                                                sh "./gradlew config_server:test"
                                            }
                                        }

                                        stage("Compile climate_service") {
                                            steps {
                                                sh "./gradlew climate_service:build"
                                              }
                                        }

                                        stage("Unit test climate_service") {
                                            steps {
                                                sh "./gradlew climate_service:test"
                                            }
                                        }
                                      
                      }
                   
        }
