INSERT INTO category(id, name, description, img) VALUES(1, 'Śniadanie', 'Pierwszy posiłek dnia', 'breakfast.jpg');
INSERT INTO category(id, name, description, img) VALUES(2, 'Obiad', 'Główny i zarazem najobfitszy posiłek w ciągu dnia', 'lunch.jpg');
INSERT INTO category(id, name, description, img) VALUES(3, 'Kolacja', 'Ostatni posiłek wieczorny', 'dinner.jpg');

INSERT INTO recipe(name, description, popularity, category_id, time_needed, difficulty) VALUES('Zapiekanka makaronowa','Cebulę pokrój w piórka, czosnek przeciśnij przez praskę. Podsmaż je na oleju. Ugotuj makaron na sposób al dente. Warzywa pokrój w paski i wraz z kurczakiem dodaj do całości. Duś około 15 minut. Następnie podlej szklanką wody i dodaj kostkę Rosołu z kury Knorr oraz przecier pomidorowy. Makaron wyłóż do naczynia żaroodpornego, zalej sosem i posyp startym serem. Włóż do piekarnika nagrzanego do 180 stopni na 20 minut.', 374, 2, 30, 'MEDIUM');
INSERT INTO recipe(name, description, popularity, category_id, time_needed, difficulty) VALUES('Omlet ze szpinakiem','Szpinak po rozmrożeniu i odsączeniu posiekaj. Mleko rozmieszaj z jajkami, pieprzem i gałką muszkatołową. Dopraw przyprawą czosnek Knorr. Na oleju zeszklij posiekaną cebulę, dodaj szpinak i przesmaż. Dodaj masę jajeczną, posyp pokruszonym serem. Smaż pod przykryciem około 5 minut, aż masa się dobrze zetnie.', 225, 1, 15, 'MEDIUM');
INSERT INTO recipe(name, description, popularity, category_id, time_needed, difficulty) VALUES('Owsianka','Wystarczy 3-4 łyżki płatków górskich zalać niewielką ilością wrzątku, poczekać kilka minut aż napęcznieją a następnie dolać do nich mleka roślinnego. Sprawdzi się sojowe, migdałowe, owsiane. Potem pozostaje już tylko dorzucenie ulubionych owoców i nasion – polecam łyżeczkę sezamu.', 750, 1, 15, 'EASY');
INSERT INTO recipe(name, description, popularity, category_id, time_needed, difficulty) VALUES('Wrapy z kurczakiem i warzywami','Zetrzyj ser na tarce; paprykę, ogórki i awokado pokrój w plastry, liście sałaty umyj i wysusz. Piersi z kurczaka pokrój na cienkie płaty, dopraw do smaku szczyptą Przyprawy do kurczaka Knorr. Usmaż go na patelni i przełóż na bok. Na tą samą patelnię wlej mleko, dodaj Fix i zagotuj. Gdy powstanie sos, dodaj starty ser. Wszystko razem gotuj jeszcze minutę. Wyłóż składniki na tortille i ułóż na patelni. Smaż około 3 minuty z każdej strony', 110, 3, 30, 'HARD');
INSERT INTO recipe(name, description, popularity, category_id, time_needed, difficulty) VALUES('Kolorowe risotto z kurczakiem','Cebulę drobno pokrój i podsmaż ją w szerokim rondlu na rozgrzanej oliwie wraz z surowym ryżem, przez 1 minutę. Pierś z kurczaka pokrój w kostkę, oprósz Przyprawą do kurczaka Knorr i obsmaż na patelni. Do podsmażonego ryżu wlej 300 mililitrów wody oraz jedną bulionetkę Knorr. Duś całość około 12 minut. Następnie dodaj mieszankę warzyw, kurczaka, zioła prowansalskie oraz 250 mililitrów wody i duś kolejne 6 minut. Pod koniec duszenia dodaj starty żółty ser, śmietanę oraz masło. Energicznie mieszaj i odstaw z ognia na kilka minut. Natychmiast podawaj.', 218, 2, 30, 'HARD');
INSERT INTO recipe(name, description, popularity, category_id, time_needed, difficulty) VALUES('Naleśniki z kurczakiem w sosie bolognese','Rozgrzej piekarnik do 200°C. Pokrój w kostkę mięso i marchewkę. Zetrzyj ser na grubej tarce. Przesmaż mięso na złoto w 1 łyżce oleju. Dodaj 200 ml wody i zawartość opakowania Knorr Naturalnie smaczne - Spaghetti Bolognese. Wymieszaj, doprowadź do wrzenia i gotuj przez ok. 5 minut. Ochłódź. Wypełnij naleśniki farszem mięsnym i zroluj. Ułóż naleśniki w dobrze natłuszczonym naczyniu do zapiekania. Rozprowadź na nich śmietanę i posyp serem. Piecz przez ok. 10 minut, do momentu gdy ser roztopi się i lekko zrumieni na złoto.', 956, 3, 30, 'EASY');
INSERT INTO recipe(name, description, popularity, category_id, time_needed, difficulty) VALUES('Szakszuka','Sparz pomidory, w tym celu wytnij z nich szypułkę a spód pomidora delikatnie nadetnij na krzyż. Pomidory umieść na około 10 sekund we wrzątku a następnie w zimnej wodzie. Z pomidorów usuń skórkę przekrój je na pół usuń środek. Pozostały miąższ pomidorowy pokrój w kosteczkę. W taką samą kosteczkę pokrój cebulę dymkę i paprykę. Posiekaj szczypior, czosnek chili i kolendrę. Na teflonowej patelni na rozgrzanej oliwie podsmaż czosnek chili i cebulę dodaj paprykę, przyprawę Knorr, smaż wszystko razem dłuższą chwilę. Dodaj pomidory , kolendrę, słodką paprykę, szczypior i kmin rzymski . Wszystko razem dokładnie wymieszaj, dopraw szczyptą soli. Podsmażone warzywa, rozłóż do małych naczynek. Do każdego naczynia wbij jajko. Całość wstaw do nagrzanego do 160*C piekarnika na około 10 minut. Danie można przygotować również na patelni. Zrób w jarzynach łyżką wgłębienia. Wbij w nie jajka. Przykryj i gotuj do ścięcia się białek. Podawaj.', 127, 1, 20, 'MEDIUM');
