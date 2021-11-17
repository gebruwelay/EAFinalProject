INSERT INTO flightreservation.`airline`
(`id`,
 `code`,
 `name`)
VALUES
    (1,
     "AA",
     "American Airline");

INSERT INTO flightreservation.`airport`
(id,
 `code`,
 `name`,
 city,state,street,zip)
VALUES
    (
        1,
        "CK",
        "CHicago",
        "Fairfield","Iowa","1000 North 4","52557");

INSERT INTO flightreservation.`passenger`
(id,
 `dateOfBirth`,
 `email`,
 firstName,
 lastName,
 city,state,street,zip)
VALUES
    ( 1,
      "1992-12-22",
      "service",
      "Gebru",
      "Welde",
      "Fairfield","Iowa","1000 North 4","52557");

INSERT INTO flightreservation.`history`
(`history`,
 `id`)
VALUES
    ("This is original",
     1);

INSERT INTO flightreservation.`flight`
(id,
 arrivalTime,
 capacity,
 departureTime,
 flightNumber,
 price,
 airline_id,
 arrivalAirport_id,
 departureAirport_id)
VALUES
    (1,
     "1992-03-25 6:00:00",
     500,
     "2021-04-24 12:00:00",
     "TIG123",
     100.0,
     1,
     1,
     1);