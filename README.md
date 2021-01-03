# Ktor with Vue Starter
### Build
To build use `gradle build` or `./gradlew build`.
This will generate a fat jar containing all needed file to serve the VueJS page with Ktor. The jar will be placed in the `bundle` folder. The build will handle `yarn build` for you as well.
### Run
To run in production `java -jar bundle/example-0.0.1.jar -port=80 -myAwesomePoperties`.
### Why?
There is no good starter repo for Ktor with VueJS.
### Todo
Implement dev environment with hot reload (partially finished for VueJS). In dev mode Vue should not be served by Ktor itself but rather both services should be available on different ports. Also, I thought about writing a setup script for Ktor with Vue. There needs to be some optimizing done with the gradle build as well.