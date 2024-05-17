.PHONY: build test clean
test: build
	./mvnw -Dbrowser=chrome -Dallure.results.directory=reports/allure -Dmaven.test.failure.ignore=true clean test

clean:
	$(RM) *.class
