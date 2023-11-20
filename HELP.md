# Telegram Business Card Bot
This Telegram bot acts as a digital business card for a company. 
Its main function is to provide general information about the company, as well as its services and pricing, 
using text, graphics, and video messages. The bot can be initiated in a variety of languages.

## Tech Stack
Backend:
- Java 11
- Maven
- Lombok

## Bot Features
- An overview of the company.
- A catalog of the company's products and services.
- Pricing details.
- Functionality to play corporate videos.
- Options for downloading product brochures or presentations.
- A feature to contact company representatives.
  
The bot offers individual customization to fit the specific needs of the company, with the potential to include additional videos, files, and sections.

## How to Use
1. Locate the bot on Telegram using its name.
2. Press the "Start" button to initiate interaction or use "/Help" to see all the available commands.
3. Navigate through the in-built features to access diverse information about the company.
   The bot's intuitive design allows users to easily obtain the information they are looking for.

## Installation and Launch
To operate this bot, you will need:
- JDK 11
- Maven
  
Clone the repository, navigate to the project directory, and then execute the following commands:
  mvn clean install
  mvn spring-boot:run

## Configuration
Before launching the bot, certain parameters in the `application.properties` file need to be set. Here, you can establish your bot's token, welcome messages, product and service descriptions, among other settings.

## License
This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for further details.