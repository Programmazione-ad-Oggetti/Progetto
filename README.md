# Progetto
Progetto per la materia "Programmazione ad Oggetti"

## Introduzione

Questa repository contiene un Web Service in grado di visualizzare tutti i Tweets relativi ad un determinato hashtag, ma anche di applicare ad essi dei filtri ed effettuare delle statistiche. 
Per lanciare l'applicazione, l'utente deve utilizzare un Client come Postman per poter effettuare delle richieste e visualizzare i dati.

## Come usare l'applicazione

Nel seguente diagramma sono schematizzate le azioni che l'utente può effettuare.

[![Use-Case-Diagram.jpg](https://i.postimg.cc/ZRVNyr9b/Use-Case-Diagram.jpg)](https://postimg.cc/9Rw06wtK)

Per effettuare queste richieste, l'utente può consultare la tabella di seguito che mostra le istruzioni per visualizzare i dati interessati:

| ROTTA | METODO | DESCRIZIONE |
| ----- | ------ | ----------- | 
| /GetInstructions | GET | L'utente può accedere ad un elenco di istruzioni utili per effettuare le richieste| 
| /tweets/{hashtag} | GET | Con questa richiesta l'utente può accedere all'intera lista di Tweets relativi all'hashtag scelto |






## Struttura dei packages e delle classi 
Di seguito vengono mostrati i diagrammi relativi allo sviluppo del progetto, per comprendere come è stato organizzato per quanto riguarda i packages e le classi. 

### Packages

In particolare, questo diagramma mostra come sono stati divisi i vari packages. 
La gerarchia vede al suo livello più alto com.EsameProgrammazione, a sua volta diviso in: 
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
