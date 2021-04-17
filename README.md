# Ktor with Vue Starter Template

### Development


#### TL;DR Hot reloading in development:

After clone run `yarn --cwd src-vue install` in project root.

In root directory of project execute:

- Terminal 1: `./gradlew -t run`
- Terminal 2: `yarn --cwd src-vue serve`


First run `yarn --cwd src-vue install` in project root or `yarn install` in the `src-vue` directory. For hot reloading you will need two
terminals. In the first terminal we want to run our backend with either
`./gradlew -t run` or `gradle -t run` when gradle is installed locally. To run the Vue Dev Server either go into
the `src-vue` directory and run `yarn serve` or execute `yarn --cwd src-vue serve` in the root directory of the project.
To kill both of these processes press `CRTL+C` in the corresponding terminal.

### Production

#### TL;DR Building for production:

In root directory of project execute:

- Terminal: `./gradlew build`

To build a Fat-JAR for production just execute `./gradlew build` or `gradle build` when gradle is installed locally.
This will include the `yarn build` of the VueJS project. The built page then will be served by Ktor in production.
To run the bundled jar from the `bundle` folder simply run `java -jar bundle/example-0.0.1.jar`. This will not work on your maschine as it wants to use port 80. You can bypass this by running `java -jar bundle/example-0.0.1.jar -port=8080`.

### Tools

- Ktor
- VueJS
- Gradle
- Yarn

### More
F0r a more complex example with Vue & Typescript and IR compiler type sharing between Ktor und Vue see https://github.com/Mari-W/ktor-vue-ir-typesharing
