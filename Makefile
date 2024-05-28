.PHONY: selenium test clean
selenium-up:
	docker-compose -f ./docker/selenium/docker-compose.yml up -d

selenium-down:
	docker-compose -f ./docker/selenium/docker-compose.yml down

test:
	./mvnw -Dbrowser=chrome -Dallure.results.directory=reports/allure -Dmaven.test.failure.ignore=true clean test

clean:
	$(RM) *.class
