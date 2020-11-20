# partielwebservice
################### REFRACTORING PARTIEL WITH WEB SERVICE#################################
## PREREQUIS: 

Installer [tomcat](https://tomcat.apache.org/tomcat-8.5-doc/setup.html)

Installer [mysql](https://dev.mysql.com/doc/refman/8.0/en/installing.html)

Installer maven

## INSTALLATION:

### ETAPE 1 : 
  Clonez le projet a partir du repository
  
### ETAPE 2 : 
  -Créer la base de donnée : ```create database partiel```

  -Executer le fichier .sql situé dans la répertoire BDD du repository.

Si vous ne changer pas les parametres de connexion de la base c'est a dire parametres par defaut qui sont : 

  Parametres par defaut
     >
  > login : "root"
  >
  > password : ""

  Passer directement a l'etape 5

  Pour  changer les parametres de connexion de la base de donnée 

  -Ouvrir le fichier de configuration partielwebservice/partielwebservice-dao/src/main/resources/META-INF/persistencce.xml

  -Changer les parametres de connection de la base de données selon votre configuration.

  >
  > login : votre-login
  >
  > password : votre-password


### ETAPE 3 :

  Generer le war aller a la racine du projet et excuter la commande:
  
    > mvn clean package
    
 ### ETAPE 4 :
 
 Deployer le war 
  
    -Récupérer le fichier war genere a partir du repertoire "partielwebservice-webservice/target/partielwebservice-webservice.war"
    
    -coller le ficher  nommé partielwebservice.war dans le repertoire webapps de tomcat
    
    -Lancer le serveur tomcat 

### ETAPE 5 :
 
 Deployer le war 
  
    -Récupérer le fichier war genere a partir de la racine  du projet serveur partielwebservice-webservice.war"
    
    -coller le fichier dans le repertoire webapps de tomcat
    
    -Lancer le serveur tomcat 


