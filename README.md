# Contact Machine

Simple java program to manage contacts, groups and message templates, and send them via WhatsApp.
#### Notes
This is a proof of concept made as a final project of Object Oriented Programing module at Universidade Europeia within the Coumputer Science bachelor program.

## Getting Started

### Prerequisites

Before cloning this project you will need a valid [Twilio](https://www.twilio.com/) Account for using their [WhatsApp API](https://www.twilio.com/whatsapp).

After a [Twilio](https://www.twilio.com/) has been created the user will have to input the account SID and a authorization token in to the program.

## Architecture

Encapsulation was one of the main objectives with this project, I followed a [facade](https://refactoring.guru/design-patterns/facade) design pattern to establish a connection between the business model of the program and rest of the outside world, so instead of having a MVC relation I've made a MC - VC, Model Controller - View Controller, with this design the model is completely hidden for the rest of the program.

### Break down of the program

#### Business model

```
pt.iade.contact.model
```
Inside this package are the class constructors and a EntitiesFacade class that contains public methods controling the business model side of the program.

#### Utilities package

```
pt.iade.contact.util
```
This package will handle utilities that are used in the program.
>Side note: this package also contains a facade to protect the management of the Twilio API.

#### View Controller Package

```
pt.iade.contact.controller
```
Package handling [JavaFx](https://openjfx.io/) views.

#### View Package

```
pt.iade.contact.view
```
Location of all FXML files created to display a user graphical interface.


## Deployment

//TODO with final version

## Built With

* JavaSE 1.8
*  JavaFX API v11.0.1
* [Scene Builder](https://gluonhq.com/products/scene-builder/) - Graphical helper for [JavaFx](https://openjfx.io/)
* [Twilio API v7.9.1](https://repo1.maven.org/maven2/com/twilio/sdk/twilio/7.9.1/) - API for WhatsApp message handling.


## Authors

* **João Calapez** - *Initial work* - [Trolorol](https://github.com/Trolorol)



## Acknowledgments

Special thanks to [Google Search](https://www.google.com/) and [Stackoverflow](https://stackoverflow.com/) without them I would´t be writing this with a smile on my face.
