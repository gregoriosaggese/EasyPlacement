-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Creato il: Nov 19, 2018 alle 19:47
-- Versione del server: 10.1.13-MariaDB
-- Versione PHP: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `EPDatabase`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `AZIENDA`
--

CREATE TABLE `AZIENDA` (
  `Nome` varchar(40) NOT NULL,
  `Sede` varchar(20) NOT NULL,
  `InizioTirocinio` varchar(50) NOT NULL,
  `FineTirocinio` varchar(50) NOT NULL,
  `Numero_Telefonico` varchar(15) NOT NULL,
  `Progetto_Offerto` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `AZIENDA`
--

INSERT INTO `AZIENDA` (`Nome`, `Sede`, `InizioTirocinio`, `FineTirocinio`, `Numero_Telefonico`, `Progetto_Offerto`) VALUES
('Apple', 'Milano', '28/01/2018', '31/01/2018', '76345233', 'Programmatore Python'),
('Cisco', 'Milano', '07/07/2018', '08/01/2019', '04312342', 'Sistemista'),
('Eustema Spa', 'Roma', '08/05/2018', '09/11/2018', '12347645', 'Database'),
('Exprivia', 'Ancona', '19/07/2018', '20/01/2019', '63415421', 'Programmatore Java'),
('Formatech', 'Firenze', '24/07/2018', '25/01/2019', '567576312', 'Programmatore Web'),
('Google', 'Milano', '13/05/2018', '14/11/2018', '43565463', 'Tester'),
('Nami Lab', 'Torino', '06/11/2018', '07/05/2019', '75634223', 'Programmatore Java'),
('Olivetti', 'Roma', '27/11/2018', '28/05/2019', '63457453', 'Programmatore Javascript'),
('prova', 'prova', '04/02/2018', '09/02/2018', 'prova', 'prova'),
('Proxel', 'Livorno', '25/08/2018', '26/02/2019', '34756345', 'Programmatore Web'),
('Qualcomm Inc', 'Salerno', '24/02/2018', '25/08/2018', '67326333', 'Programmatore Java'),
('Samsung', 'Torino', '11/11/2018', '12/05/2019', '78457122', 'Programmatore Web'),
('Sec Lab', 'Domodossola', '23/07/2018', '24/01/2019', '89734503', 'Sistemista'),
('Sinapto', 'Napoli', '24/10/2018', '25/04/2019', '54702342', 'Programmatore Python'),
('Sisal Spa', 'Modena', '08/02/2018', '09/08/2018', '6774359', 'Programmatore Python'),
('Tim', 'Salerno', '24/06/2018', '25/12/2018', '5478233', 'Programmatore MIPS');

-- --------------------------------------------------------

--
-- Struttura della tabella `PRESIDENTE CONSIGLIO DIDATTICO`
--

CREATE TABLE `PRESIDENTE CONSIGLIO DIDATTICO` (
  `Nome_Utente` varchar(50) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `PRESIDENTE CONSIGLIO DIDATTICO`
--

INSERT INTO `PRESIDENTE CONSIGLIO DIDATTICO` (`Nome_Utente`, `Nome`, `Cognome`, `Password`) VALUES
('filomena_ferrucci_presidenteConsiglioDidattico', 'filomena', 'ferrucci', 'filomenaferrucci');

-- --------------------------------------------------------

--
-- Struttura della tabella `PROGETTO FORMATIVO`
--

CREATE TABLE `PROGETTO FORMATIVO` (
  `Id` int(10) NOT NULL,
  `Nome` varchar(50) NOT NULL,
  `Cognome` varchar(50) NOT NULL,
  `Residenza` varchar(50) NOT NULL,
  `Via` varchar(50) NOT NULL,
  `Nato a` varchar(50) NOT NULL,
  `Nato il` varchar(50) NOT NULL,
  `Codice Fiscale` varchar(50) NOT NULL,
  `Telefono` varchar(50) NOT NULL,
  `Firma_Azienda` tinyint(1) NOT NULL,
  `Firma_Tutor_Aziendale` tinyint(1) NOT NULL,
  `Firma_Presidente_Consiglio_Didattico` tinyint(1) NOT NULL,
  `Firma_Tutor_Accademico` tinyint(1) NOT NULL,
  `Firma_Studente` tinyint(1) NOT NULL,
  `Email_Studente` varchar(40) NOT NULL,
  `Nome_Utente_Responsabile_Aziendale` varchar(40) NOT NULL,
  `Nome_Utente_Tutor_Aziendale` varchar(40) NOT NULL,
  `Nome_Utente_Tutor_Accademico` varchar(40) NOT NULL,
  `Opzione` tinyint(1) NOT NULL,
  `IscrittoAl` varchar(50) NOT NULL,
  `AnnoCorsoLaurea` varchar(50) NOT NULL,
  `LaureaIn` varchar(50) NOT NULL,
  `Matricola` varchar(50) NOT NULL,
  `AnnoAccademico` varchar(50) NOT NULL,
  `NumeroCFU` int(10) NOT NULL,
  `TipoLaurea` tinyint(1) NOT NULL,
  `DataConseguimentoLaurea` varchar(50) NOT NULL,
  `InpossessodiLaurea` varchar(50) NOT NULL,
  `PortatoreHandicap` tinyint(1) NOT NULL,
  `DataFirma` varchar(40) NOT NULL,
  `DataInizio` varchar(30) NOT NULL,
  `DataFine` varchar(30) NOT NULL,
  `Sede` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `PROGETTO FORMATIVO`
--

INSERT INTO `PROGETTO FORMATIVO` (`Id`, `Nome`, `Cognome`, `Residenza`, `Via`, `Nato a`, `Nato il`, `Codice Fiscale`, `Telefono`, `Firma_Azienda`, `Firma_Tutor_Aziendale`, `Firma_Presidente_Consiglio_Didattico`, `Firma_Tutor_Accademico`, `Firma_Studente`, `Email_Studente`, `Nome_Utente_Responsabile_Aziendale`, `Nome_Utente_Tutor_Aziendale`, `Nome_Utente_Tutor_Accademico`, `Opzione`, `IscrittoAl`, `AnnoCorsoLaurea`, `LaureaIn`, `Matricola`, `AnnoAccademico`, `NumeroCFU`, `TipoLaurea`, `DataConseguimentoLaurea`, `InpossessodiLaurea`, `PortatoreHandicap`, `DataFirma`, `DataInizio`, `DataFine`, `Sede`) VALUES
(2, 'Giovanni', 'Ursi', 'wewerwerwe', 'werwerwerwe', 'werwerwer', 'werwerwer', 'werrrrrrrrrrrrrr', '13123123', 1, 1, 1, 1, 1, 'studente2@gmail.com', 'prova_responsabileAziendale', 'prova_tutorAziendale', 'donatello_botti_tutorAccademico', 0, 'Primo Triennale', '2017/2018', '1', '12123', '2017/2018', 123, 0, '', 'none', 1, '05/02/2018', '04/02/2018', '09/02/2018', 'prova');

-- --------------------------------------------------------

--
-- Struttura della tabella `REGISTRO`
--

CREATE TABLE `REGISTRO` (
  `Data` varchar(20) NOT NULL,
  `Firma` tinyint(1) NOT NULL,
  `Id_Progetto_Formativo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `REGISTRO`
--

INSERT INTO `REGISTRO` (`Data`, `Firma`, `Id_Progetto_Formativo`) VALUES
('04/02/2018', 1, 2),
('05/02/2018', 1, 2),
('07/02/2018', 1, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `RESPONSABILE AZIENDALE`
--

CREATE TABLE `RESPONSABILE AZIENDALE` (
  `Nome_Utente` varchar(40) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Nome_Azienda` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `RESPONSABILE AZIENDALE`
--

INSERT INTO `RESPONSABILE AZIENDALE` (`Nome_Utente`, `Nome`, `Cognome`, `Password`, `Nome_Azienda`) VALUES
('', '', '', '', ''),
('carmine_gravino_responsabileAziendale', 'Carmine', 'Gravino', 'carminegravino', 'Apple'),
('daniele_lupo_responsabileAziendale', 'Daniele', 'Lupo', 'danielelupo', 'Tim'),
('eleonora_giuliani_responsabileAziendale', 'Eleonora', 'Giuliani', 'eleonoragiuliani', 'Eustema Spa'),
('francesco_piccolo_responsabileAziendale', 'Francesco', 'Piccolo', 'francescopiccolo', 'Proxel'),
('gemma_catolino_responsabileAziendale', 'Gemma', 'Catolino', 'gemmacatolino', 'Qualcomm Inc'),
('giovanni_capaccio_responsabileAziendale', 'Giovanni', 'Capaccio', 'giovannicapaccio', 'Sisal Spa'),
('ivan_rizzo_responsabileAziendale', 'Ivan', 'Rizzo', 'ivanrizzo', 'Google'),
('luigi_sica_responsabileAziendale', 'Luigi', 'Sica', 'luigisica', 'Sec Lab'),
('mario_rossi_responsabileAziendale', 'Mario', 'Rossi', 'mariorossi', 'Nami Lab'),
('pierluigi_pardo_responsabileAziendale', 'Pierluigi', 'Pardo', 'pierluigipardo', 'Formatech'),
('prova_responsabileAziendale', 'prova', 'prova', 'prova', 'prova'),
('raffaele_sibilla_responsabileAziendale', 'Raffaele', 'Sibilla', 'raffaelesibilla', 'Exprivia'),
('rosy_esposito_responsabileAziendale', 'Rosy', 'Esposito', 'rosyesposito', 'Samsung'),
('silvio_risi_responsabileAziendale', 'Silvio', 'Risi', 'silviorisi', 'Cisco'),
('simone_petrosino_responsabileAziendale', 'Simone', 'Petrosino', 'simonepetrosino', 'Olivetti'),
('stefano_sarro_responsabileAziendale', 'Stefano', 'Sarro', 'stefanosarro', 'Sinapto');

-- --------------------------------------------------------

--
-- Struttura della tabella `RICHIESTA`
--

CREATE TABLE `RICHIESTA` (
  `id_studente` int(10) NOT NULL,
  `Stato` tinyint(1) NOT NULL,
  `Nome` varchar(40) NOT NULL,
  `Cognome` varchar(40) NOT NULL,
  `Matricola` varchar(40) NOT NULL,
  `Responsabile Aziendale` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Struttura della tabella `STUDENTE`
--

CREATE TABLE `STUDENTE` (
  `studente_id` int(10) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Numero_Telefonico` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `STUDENTE`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `TIROCINIO`
--

CREATE TABLE `TIROCINIO` (
  `Data_Inizio` varchar(50) NOT NULL,
  `Data_Fine` varchar(50) NOT NULL,
  `Sede` varchar(40) NOT NULL,
  `Email_studente` varchar(40) NOT NULL,
  `Id_Progetto_Formativo` int(10) NOT NULL,
  `Completato` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `TIROCINIO`
--


-- --------------------------------------------------------

--
-- Struttura della tabella `TUTOR ACCADEMICO`
--

CREATE TABLE `TUTOR ACCADEMICO` (
  `Nome_Utente` varchar(40) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `TUTOR ACCADEMICO`
--

INSERT INTO `TUTOR ACCADEMICO` (`Nome_Utente`, `Nome`, `Cognome`, `Password`) VALUES
('donatello_botti_tutorAccademico', 'Donatello', 'Botti', 'donatellobotti');

-- --------------------------------------------------------

--
-- Struttura della tabella `TUTOR AZIENDALE`
--

CREATE TABLE `TUTOR AZIENDALE` (
  `Nome_Utente` varchar(40) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Numero_Telefonico` varchar(15) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `Nome_azienda` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `TUTOR AZIENDALE`
--

INSERT INTO `TUTOR AZIENDALE` (`Nome_Utente`, `Nome`, `Cognome`, `Password`, `Numero_Telefonico`, `Email`, `Nome_azienda`) VALUES
('arturo_vidal_tutorAziendale', 'Arturo', 'Vidal', 'arturovidal', '2342322', 'arturovidal@gmail.com', 'Sisal Spa'),
('francesco_frunzi_tutorAziendale', 'Francesco', 'Frunzi', 'francescofrunzi', '33211123', 'francescofrunzi@gmail.com', 'Proxel'),
('gdaniele_monza_tutorAziendale', 'Daniele', 'Monza', 'danielemonza', '44322334', 'danielemonza@gmail.com', 'Sinapto'),
('gianpaolo_olti_tutorAziendale', 'Gianpaolo', 'Olti', 'gianpaoloolti', '8985895', 'gianpaoloolti@gmail.com', 'Nami Lab'),
('giulio_perna_tutorAziendale', 'Giulio', 'Perna', 'giulioperna', '3424233', 'giulioperna@gmail.com', 'Eustema Spa'),
('giuseppe_pacelli_tutorAziendale', 'Giuseppe', 'Pacelli', 'giuseppepacelli', '32411175', 'giuseppepacelli@gmail.com', 'Samsung'),
('luca_imal_tutorAziendale', 'Luca', 'Imal', 'lucaimal', '985455', 'lucaimal@gmail.com', 'Qualcomm Inc'),
('mario_rossi_tutorAziendale', 'Mario', 'Rossi', 'mariorossi', '34675233', 'mariorossi@gmail.com', 'Cisco'),
('milo_esposito_tutorAziendale', 'Milo', 'Esposito', 'miloesposito', '4343222', 'miloesposito@gmail.com', 'Exprivia'),
('mirco_feoli_tutorAziendale', 'Mirco', 'Feoli', 'mircofeoli', '62326333', 'mircofeoli@gmail.com', 'Sec Lab'),
('prova_tutorAziendale', 'prova', 'prova', 'prova', 'prova', 'prova', 'prova'),
('raffaele_deprisco_tutorAziendale', 'Raffaele', 'De Prisco', 'raffaeledeprisco', '3211124', 'raffaeledeprisco@gmail.com', 'Olivetti'),
('rosario_lordi_tutorAziendale', 'Rosario', 'Lordi', 'rosariolordi', '2342322', 'rosariolordi@gmail.com', 'Formatech');

-- --------------------------------------------------------

--
-- Struttura della tabella `UFFICIO STAGE E TIROCINI`
--

CREATE TABLE `UFFICIO STAGE E TIROCINI` (
  `Nome_Utente` varchar(40) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `UFFICIO STAGE E TIROCINI`
--

INSERT INTO `UFFICIO STAGE E TIROCINI` (`Nome_Utente`, `Password`) VALUES
('ufficioStageETirocini', 'defaultdefault');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `AZIENDA`
--
ALTER TABLE `AZIENDA`
  ADD PRIMARY KEY (`Nome`);

--
-- Indici per le tabelle `PRESIDENTE CONSIGLIO DIDATTICO`
--
ALTER TABLE `PRESIDENTE CONSIGLIO DIDATTICO`
  ADD PRIMARY KEY (`Nome_Utente`);

--
-- Indici per le tabelle `PROGETTO FORMATIVO`
--
ALTER TABLE `PROGETTO FORMATIVO`
  ADD PRIMARY KEY (`Id`);

--
-- Indici per le tabelle `REGISTRO`
--
ALTER TABLE `REGISTRO`
  ADD PRIMARY KEY (`Data`);

--
-- Indici per le tabelle `RESPONSABILE AZIENDALE`
--
ALTER TABLE `RESPONSABILE AZIENDALE`
  ADD PRIMARY KEY (`Nome_Utente`);

--
-- Indici per le tabelle `RICHIESTA`
--
ALTER TABLE `RICHIESTA`
  ADD PRIMARY KEY (`id_studente`);

--
-- Indici per le tabelle `STUDENTE`
--
ALTER TABLE `STUDENTE`
  ADD PRIMARY KEY (`studente_id`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indici per le tabelle `TUTOR ACCADEMICO`
--
ALTER TABLE `TUTOR ACCADEMICO`
  ADD PRIMARY KEY (`Nome_Utente`);

--
-- Indici per le tabelle `TUTOR AZIENDALE`
--
ALTER TABLE `TUTOR AZIENDALE`
  ADD PRIMARY KEY (`Nome_Utente`);

--
-- Indici per le tabelle `UFFICIO STAGE E TIROCINI`
--
ALTER TABLE `UFFICIO STAGE E TIROCINI`
  ADD PRIMARY KEY (`Nome_Utente`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `STUDENTE`
--
ALTER TABLE `STUDENTE`
  MODIFY `studente_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
