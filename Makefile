.PHONY: build test clean
test: build
	./mvnw -Dbrowser=chrome -Dallure.results.directory=allure-results -Dmaven.test.failure.ignore=true clean test

clean:
	$(RM) *.class
