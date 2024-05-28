.PHONY: selenium test clean
selenium:
	docker-compose -f ./docker/selenium/docker-compose.yml up -d

test:
	./mvnw -Dbrowser=chrome -Dallure.results.directory=reports/allure -Dmaven.test.failure.ignore=true clean test

clean:
	$(RM) *.class
