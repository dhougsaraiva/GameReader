# 📊 GameReader

GameReader é um projeto de **Web Scraping** desenvolvido para **extração, processamento e persistência de dados estatísticos** de jogadores da **National Basketball Association (NBA)**.

O objetivo do projeto é coletar informações detalhadas de partidas e atletas, estruturar esses dados e armazená‑los em banco de dados, criando uma base confiável para análises e estudos estatísticos.

---

## 🔎 Fonte dos Dados

Os dados são obtidos a partir do site **basketball-reference**, referência amplamente utilizada para estatísticas históricas e informações detalhadas da NBA.

Durante o processo, o sistema:

* Identifica as partidas disponíveis
* Reconhece os times envolvidos
* Mapeia os jogadores participantes
* Extrai estatísticas individuais de cada jogo

---

## 🗄️ Persistência

Após a coleta e o tratamento das informações, os dados são inseridos em uma **tabela MySQL**, garantindo organização, integridade e facilidade de consulta para usos futuros.

