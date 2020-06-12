# Progetto
Progetto per la materia "Programmazione ad Oggetti"

## Introduzione

Questa repository contiene un Web Service in grado di visualizzare tutti i Tweets relativi ad un determinato hashtag, ma anche di applicare ad essi dei filtri ed effettuare delle statistiche. 
Per lanciare l'applicazione, l'utente deve utilizzare un Client come Postman per poter effettuare delle richieste e visualizzare i dati.
Per comprendere al meglio il funzionamento, l'utente può consultare i punti elencati di seguito in cui viene spiegato nel dettaglio come 
il nostro progetto è stato organizzato e sviluppato. 

* [Come usare l'applicazione](#Come-usare-l'applicazione)
* [Struttura dei packages e delle classi](#Struttura-dei-packages-e-delle-classi)
* [Chiamate](#Chiamate)
* [Software](#Software)
* [Autori](#Autori) 

## Come usare l'applicazione

Nel seguente diagramma sono schematizzate le azioni che l'utente può effettuare.

[![Use-Case-Diagram.jpg](https://i.postimg.cc/ZRVNyr9b/Use-Case-Diagram.jpg)](https://postimg.cc/9Rw06wtK)

Per effettuare queste richieste, l'utente può consultare la tabella di seguito che mostra le istruzioni per visualizzare i dati interessati:

| ROTTA | METODO | DESCRIZIONE |
| ----- | ------ | ----------- | 
| /GetInstructions | GET | L'utente può accedere ad un elenco di istruzioni utili per effettuare le richieste| 
| /tweets/{hashtag} | GET | Con questa richiesta l'utente può accedere all'intera lista di Tweets relativi all'hashtag scelto |
| /tweets/{hashtag} |  POST | Con questo comando l'utente può accedere ai Tweets relativi all'hashtag scelto, secondo un certo filtro inserito nel body |
| /GetStatsLike/{hashtag} | POST |  Con questo comando l'utente può visualizzare le statistiche relative ai like, secondo un certo filtro immesso nel body |
| /GetStatsDate/{hashtag} | POST |  Con questo comando l'utente può visualizzare le statistiche relative alla data immessa nel body, secondo un certo filtro immesso nel body |


| ESEMPI | SPIEGAZIONE |
| ------ | ----------- | 
| /tweets/univpm | Questa richiesta permette di visualizzare tutti i Tweet contenenti l'hashtag "univpm" |
| {"like":{"$gt": 250}} | Questa richiesta permette di visualizzare i Tweet che hanno più di 250 like |
|{"$and":[{"data":{"eq" : 02 05}},{"like":{"$gt": 30 }}]} | Questa richiesta permette di visualizzare i Tweet riferiti al 5 Febbraio, i quali, a loro volta, hanno più di 30 like |





## Struttura dei packages e delle classi 
Di seguito vengono mostrati i diagrammi relativi allo sviluppo del progetto, per comprendere come è stato organizzato per quanto riguarda i packages e le classi. 

### Packages

In particolare, questo diagramma mostra come sono stati divisi i vari packages. 
La gerarchia vede al suo livello più alto esame.EsameProgrammazione, a sua volta diviso in: 
* controller
* service 
* exceptions
* model 
* database 
* filter
* statistics

[![Package-Hierarchy.jpg](https://i.postimg.cc/hjzHw09v/Package-Hierarchy.jpg)](https://postimg.cc/HcmZ8Xv1)

### Classi

Entrando ancora di più nel dettaglio, esaminiamo ogni package e ogni classe contenuta al suo interno:

* esame.EsameProgrammazione.controller
* esame.EsameProgrammazione.service
* esame.EsameProgrammazione.exceptions

[![exceptions.jpg](https://i.postimg.cc/Cx0WwrZf/exceptions.jpg)](https://postimg.cc/ZCffccxT)

* esame.EsameProgrammazione.model
* esame.EsameProgrammazione.database

[![database.jpg](https://i.postimg.cc/0j6VCDzv/database.jpg)](https://postimg.cc/tnjdq1dv)

* esame.EsameProgrammazione.filter
* esame.EsameProgrammazione.statistics


## Chiamate

In questo punto esaminiamo nello specifico le chiamate che l'utente può effettuare utilizzando i diagrammi delle sequenze, i quali mostrano come interagiscono tra di loro gli oggetti delle varie classi e forniscono informazioni anche di tipo temporale, poiché le interazioni nel diagramma vengono disposte in ordine cronologico.

* GET /GetInstructions





## Software

* [Eclipse](https://www.eclipse.org/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Maven](https://maven.apache.org/)

## Autori 

* Antonio Colucci
* Carmen Andreozzi
