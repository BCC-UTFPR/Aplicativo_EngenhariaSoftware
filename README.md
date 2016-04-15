# Aplicativo_EngenhariaSoftware
Este repositório agrupa os códigos desenvolvidos no projeto de Engenharia de Software I.

Configuração do Hibernate
---
1. Ativar mysql sudo service mysql start
2. create database FleetTrackingPU;
3. Netbeans > serviços 
4. Botao direito new connection;
5. Seleciona o driver Mysql
6. Next
7. Database: FleetTrackingPU
8. senha de root > remmember password > test connection
9. Apagar na opção JDBC Url tudo que está antes da interrogação: ?zeroDateTimeBehavior=convertToNull
10. Depois de terminado a configuração do Conexão volta na aba Projects;
11. Clica no pacote META-INF
12. Abrir persistence.xml;
13. Aba source do arquivo modificar o password do root mysql

		Professora: Ana Paula Steinmacher
		Alunos: André Monegat
			Matheus Renato
			João Martins
			Felipe Fronchetti
			Vinícius Morais
