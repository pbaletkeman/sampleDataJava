package ca.letkeman;

import com.github.javafaker.Faker;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

public class Main {

  private static Logger logger = Logger.getLogger(Main.class.getName());

  Faker faker = new Faker();

  public static void main(String[] args) {
logger.info("command line parameters, everythng is optional:");
logger.info(" file:filename buffy:#records ancient:#records beer:#records book:#records person:#records business:#records commerce:#records food:#records");
logger.info("e.g.:\nfile:test.db buffy:10 ancient:10 beer:10 book:10 person:10 business:10 commerce:10 food:10");
    Main m = new Main();
    m.createData(args);

  }

  public void createData(String[] args) {

    String dbFileName = "test.db";
    int buffy = -1;
    int ancient = -1;
    int beer = -1;
    int book = -1;
    int person = -1;
    int business = -1;
    int commerce = -1;
    int food = -1;
    for (String val : args) {
      if (val.toLowerCase().contains("file:")) {
        dbFileName = val.toLowerCase().replace("file:", "");
      } else if (val.toLowerCase().contains("buffy:")) {
        buffy = Integer.parseInt(val.toLowerCase().replace("buffy:", ""));
      } else if (val.toLowerCase().contains("ancient:")) {
        ancient = Integer.parseInt(val.toLowerCase().replace("ancient:", ""));
      } else if (val.toLowerCase().contains("beer:")) {
        beer = Integer.parseInt(val.toLowerCase().replace("beer:", ""));
      } else if (val.toLowerCase().contains("book:")) {
        book = Integer.parseInt(val.toLowerCase().replace("book:", ""));
      } else if (val.toLowerCase().contains("person:")) {
        person = Integer.parseInt(val.toLowerCase().replace("person:", ""));
      } else if (val.toLowerCase().contains("business:")) {
        business = Integer.parseInt(val.toLowerCase().replace("business:", ""));
      } else if (val.toLowerCase().contains("commerce:")) {
        commerce = Integer.parseInt(val.toLowerCase().replace("commerce:", ""));
      } else if (val.toLowerCase().contains("food:")) {
        food = Integer.parseInt(val.toLowerCase().replace("food:", ""));
      }
    }
    // Printing command line arguments

    // connection string
    String url = "jdbc:sqlite:" + dbFileName;

    try (java.sql.Connection conn = DriverManager.getConnection(url)) {
      logger.info("Connection to SQLite has been established.");
      if (buffy > 0) {
        createBuffy(buffy, conn, false);
      }
      if (ancient > 0) {
        createAncient(ancient, conn, false);
      }
      if (beer > 0) {
        createBeer(beer, conn, false);
      }
      if (book > 0) {
        createBook(book, conn, false);
      }
      if (person > 0) {
        createPerson(person, conn, false);
      }
      if (business > 0) {
        createBusiness(business, conn, false);
      }
      if (commerce > 0) {
        createCommerce(commerce, conn, false);
      }
      if (food > 0) {
        createFood(food, conn, false);
      }


    } catch (SQLException e) {
      logger.info(e.getMessage());
    }
  }


  private void createBuffy(int numOfRecs, java.sql.Connection conn, boolean drop) {

    String createTable = "CREATE TABLE IF NOT EXISTS buffy (id INTEGER PRIMARY KEY, bigBads TEXT, celebrities TEXT, characters TEXT, quotes TEXT, episodes TEXT);";
    String sqlString = "INSERT INTO  buffy (bigBads, celebrities, characters, quotes, episodes) VALUES (?, ?, ?, ?, ?);";
    String deleteTable = "DROP TABLE IF EXISTS buffy";
    if (drop) {
      try (Statement stmt = conn.createStatement()) {
        stmt.execute(deleteTable);

      } catch (SQLException e) {
        logger.info(e.getMessage());
      }
    }
    try (Statement stmt = conn.createStatement()) {
      stmt.execute(createTable);
    } catch (SQLException e) {
      logger.info(e.getMessage());
    }
    try (PreparedStatement stmt = conn.prepareStatement(sqlString)) {
      for (int i = 0; i < numOfRecs; i++) {
        stmt.setString(1, faker.buffy().bigBads());
        stmt.setString(2, faker.buffy().celebrities());
        stmt.setString(3, faker.buffy().characters());
        stmt.setString(4, faker.buffy().quotes());
        stmt.setString(5, faker.buffy().episodes());
        logger.info("Buffy Record - " + (i + 1) + "/" + numOfRecs);
        stmt.addBatch();
      }
      stmt.executeBatch();
    } catch (SQLException e) {
      logger.info(e.getMessage());
    }
  }

  private void createAncient(int numOfRecs, java.sql.Connection conn, boolean drop) {
    String createTable = "CREATE TABLE IF NOT EXISTS ancient (id INTEGER PRIMARY KEY, god TEXT, hero TEXT, primordial TEXT, titan TEXT);";
    String sqlString = "INSERT INTO ancient (god, hero, primordial, titan) VALUES (?, ?, ?, ?);";
    String deleteTable = "DROP TABLE IF EXISTS ancient";
    if (drop) {
      try (Statement stmt = conn.createStatement()) {
        stmt.execute(deleteTable);

      } catch (SQLException e) {
        logger.info(e.getMessage());
      }
    }
    try (Statement stmt = conn.createStatement()) {
      stmt.execute(createTable);
    } catch (SQLException e) {
      logger.info(e.getMessage());
    }
    try (PreparedStatement stmt = conn.prepareStatement(sqlString)) {
      for (int i = 0; i < numOfRecs; i++) {
        stmt.setString(1, faker.ancient().god());
        stmt.setString(2, faker.ancient().hero());
        stmt.setString(3, faker.ancient().primordial());
        stmt.setString(4, faker.ancient().titan());
        logger.info("Ancient Record - " + (i + 1) + "/" + numOfRecs);
        stmt.addBatch();
      }
      stmt.executeBatch();
    } catch (SQLException e) {
      logger.info(e.getMessage());
    }
  }

  private void createBeer(int numOfRecs, java.sql.Connection conn, boolean drop) {
    String createTable = "CREATE TABLE IF NOT EXISTS beer (id INTEGER PRIMARY KEY, hop TEXT, style TEXT, name TEXT, malt TEXT, yeast TEXT);";
    String sqlString = "INSERT INTO beer (hop, style, name, malt, yeast) VALUES (?, ?, ?, ?, ?);";
    String deleteTable = "DROP TABLE IF EXISTS beer";
    if (drop) {
      try (Statement stmt = conn.createStatement()) {
        stmt.execute(deleteTable);

      } catch (SQLException e) {
        logger.info(e.getMessage());
      }
    }
    try (Statement stmt = conn.createStatement()) {
      stmt.execute(createTable);
    } catch (SQLException e) {
      logger.info(e.getMessage());
    }
    try (PreparedStatement stmt = conn.prepareStatement(sqlString)) {
      for (int i = 0; i < numOfRecs; i++) {
        stmt.setString(1, faker.beer().hop());
        stmt.setString(2, faker.beer().style());
        stmt.setString(3, faker.beer().name());
        stmt.setString(4, faker.beer().malt());
        stmt.setString(5, faker.beer().yeast());
        logger.info("Beer Record - " + (i + 1) + "/" + numOfRecs);
        stmt.addBatch();
      }
      stmt.executeBatch();
    } catch (SQLException e) {
      logger.info(e.getMessage());
    }
  }

  private void createBook(int numOfRecs, java.sql.Connection conn, boolean drop) {
    String createTable = "CREATE TABLE IF NOT EXISTS book (id INTEGER PRIMARY KEY, genre TEXT, publisher TEXT, author TEXT, title TEXT, isbn13 TEXT);";
    String sqlString = "INSERT INTO book (genre, publisher, author, title, isbn13) VALUES (?, ?, ?, ?, ?);";
    String deleteTable = "DROP TABLE IF EXISTS book";
    if (drop) {
      try (Statement stmt = conn.createStatement()) {
        stmt.execute(deleteTable);

      } catch (SQLException e) {
        logger.info(e.getMessage());
      }
    }
    try (Statement stmt = conn.createStatement()) {
      stmt.execute(createTable);
    } catch (SQLException e) {
      logger.info(e.getMessage());
    }
    try (PreparedStatement stmt = conn.prepareStatement(sqlString)) {
      for (int i = 0; i < numOfRecs; i++) {
        stmt.setString(1, faker.book().genre());
        stmt.setString(2, faker.book().publisher());
        stmt.setString(3, faker.book().author());
        stmt.setString(4, faker.book().title());
        stmt.setString(5, faker.code().isbn13());
        logger.info("Book Record - " + (i + 1) + "/" + numOfRecs);
        stmt.addBatch();
      }
      stmt.executeBatch();
    } catch (SQLException e) {
      logger.info(e.getMessage());
    }
  }

  private void createPerson(int numOfRecs, java.sql.Connection conn, boolean drop) {
    String createTable = "CREATE TABLE IF NOT EXISTS person (id INTEGER PRIMARY KEY, sex TEXT, maritalStatus TEXT, race TEXT, educationalAttainment TEXT, firstName TEXT, lastName TEXT, title TEXT, bloodGroup TEXT, username TEXT, birthday TEXT, buildingNumber TEXT, streetAddress TEXT, city TEXT, country TEXT, state TEXT);";
    String sqlString = "INSERT INTO person (sex, maritalStatus, race, educationalAttainment, firstName, lastName, title, bloodGroup, username, birthday, buildingNumber, streetAddress, city, country, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    String deleteTable = "DROP TABLE IF EXISTS person";
    if (drop) {
      try (Statement stmt = conn.createStatement()) {
        stmt.execute(deleteTable);

      } catch (SQLException e) {
        logger.info(e.getMessage());
      }
    }
    try (Statement stmt = conn.createStatement()) {
      stmt.execute(createTable);
    } catch (SQLException e) {
      logger.info(e.getMessage());
    }
    try (PreparedStatement stmt = conn.prepareStatement(sqlString)) {
      String pattern = "yyyy-MM-dd";
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
      for (int i = 0; i < numOfRecs; i++) {
        stmt.setString(1, faker.demographic().sex());
        stmt.setString(2, faker.demographic().maritalStatus());
        stmt.setString(3, faker.demographic().race());
        stmt.setString(4, faker.demographic().educationalAttainment());
        stmt.setString(5, faker.name().firstName());
        stmt.setString(6, faker.name().lastName());
        stmt.setString(7, faker.name().title());
        stmt.setString(8, faker.name().bloodGroup());
        stmt.setString(9, faker.name().username());
        stmt.setString(10, simpleDateFormat.format(faker.date().birthday()));
        stmt.setString(11, faker.address().buildingNumber());
        stmt.setString(12, faker.address().streetAddress(true));
        stmt.setString(13, faker.address().city());
        stmt.setString(14, faker.address().country());
        stmt.setString(15, faker.address().state());
        logger.info("Person Record - " + (i + 1) + "/" + numOfRecs);
        stmt.addBatch();
      }
      stmt.executeBatch();
    } catch (SQLException e) {
      logger.info(e.getMessage());
    }

  }

  private void createBusiness(int numOfRecs, java.sql.Connection conn, boolean drop) {
    String createTable = "CREATE TABLE IF NOT EXISTS business (id INTEGER PRIMARY KEY, creditCardExpiry TEXT, creditCardNumber TEXT, creditCardType TEXT, code TEXT, name TEXT);";
    String sqlString = "INSERT INTO business (creditCardExpiry, creditCardNumber, creditCardType, code, name) VALUES (?, ?, ?, ?, ?);";
    String deleteTable = "DROP TABLE IF EXISTS business";
    if (drop) {
      try (Statement stmt = conn.createStatement()) {
        stmt.execute(deleteTable);

      } catch (SQLException e) {
        logger.info(e.getMessage());
      }
    }
    try (Statement stmt = conn.createStatement()) {
      stmt.execute(createTable);
    } catch (SQLException e) {
      logger.info(e.getMessage());
    }
    try (PreparedStatement stmt = conn.prepareStatement(sqlString)) {
      for (int i = 0; i < numOfRecs; i++) {
        stmt.setString(1, faker.business().creditCardExpiry());
        stmt.setString(2, faker.business().creditCardNumber());
        stmt.setString(3, faker.business().creditCardType());
        stmt.setString(4, faker.currency().code());
        stmt.setString(5, faker.currency().name());
        logger.info("Business Record - " + (i + 1) + "/" + numOfRecs);
        stmt.addBatch();
      }
      stmt.executeBatch();
    } catch (SQLException e) {
      logger.info(e.getMessage());
    }
  }

  private void createCommerce(int numOfRecs, java.sql.Connection conn, boolean drop) {
    String createTable = "CREATE TABLE IF NOT EXISTS commerce (id INTEGER PRIMARY KEY, color TEXT, department TEXT, material TEXT, price TEXT, productName TEXT, promotionCode TEXT);";
    String sqlString = "INSERT INTO commerce (color, department, material, price, productName, promotionCode) VALUES (?, ?, ?, ?, ?, ?);";
    String deleteTable = "DROP TABLE IF EXISTS commerce";
    if (drop) {
      try (Statement stmt = conn.createStatement()) {
        stmt.execute(deleteTable);

      } catch (SQLException e) {
        logger.info(e.getMessage());
      }
    }
    try (Statement stmt = conn.createStatement()) {
      stmt.execute(createTable);
    } catch (SQLException e) {
      logger.info(e.getMessage());
    }
    try (PreparedStatement stmt = conn.prepareStatement(sqlString)) {
      for (int i = 0; i < numOfRecs; i++) {
        stmt.setString(1, faker.commerce().color());
        stmt.setString(2, faker.commerce().department());
        stmt.setString(3, faker.commerce().material());
        stmt.setString(4, faker.commerce().price());
        stmt.setString(5, faker.commerce().productName());
        stmt.setString(6, faker.commerce().promotionCode());
        logger.info("Commerce Record - " + (i + 1) + "/" + numOfRecs);
        stmt.addBatch();
      }
      stmt.executeBatch();
    } catch (SQLException e) {
      logger.info(e.getMessage());
    }
  }

  private void createFood(int numOfRecs, java.sql.Connection conn, boolean drop) {
    String createTable = "CREATE TABLE IF NOT EXISTS food (id INTEGER PRIMARY KEY, dish TEXT, fruit TEXT, ingredient TEXT, spice TEXT, measurement TEXT, vegetable TEXT);";
    String sqlString = "INSERT INTO food (dish, fruit, ingredient, spice, measurement, vegetable) VALUES (?, ?, ?, ?, ?, ?);";
    String deleteTable = "DROP TABLE IF EXISTS food";
    if (drop) {
      try (Statement stmt = conn.createStatement()) {
        stmt.execute(deleteTable);

      } catch (SQLException e) {
        logger.info(e.getMessage());
      }
    }
    try (Statement stmt = conn.createStatement()) {
      stmt.execute(createTable);
    } catch (SQLException e) {
      logger.info(e.getMessage());
    }
    try (PreparedStatement stmt = conn.prepareStatement(sqlString)) {
      for (int i = 0; i < numOfRecs; i++) {
        stmt.setString(1, faker.food().dish());
        stmt.setString(2, faker.food().fruit());
        stmt.setString(3, faker.food().ingredient());
        stmt.setString(4, faker.food().spice());
        stmt.setString(5, faker.food().measurement());
        stmt.setString(6, faker.food().vegetable());
        logger.info("Food Record - " + (i + 1) + "/" + numOfRecs);
        stmt.addBatch();
      }
      stmt.executeBatch();
    } catch (SQLException e) {
      logger.info(e.getMessage());
    }
  }
}
