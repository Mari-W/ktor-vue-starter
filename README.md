# Ktor with Vue Starter Template

### Development

This template includes hot reloading for both Ktor and VueJS. For perfect development experience you will need two
terminals. In the first terminal we want to run our backend with either
`./gradlew -t run` or `gradle -t run` when gradle is installed locally. To run the Vue Dev Server either go into
the `src-vue` directory and run `yarn serve` or execute `yarn --cwd src-vue serve` in the root directory of the project.
To kill both of these processes press `CRTL+C` in the corresponding terminal.

#### TL;DR Hot reloading:

In root directory of project execute:

- Terminal 1: `./gradlew -t run`
- Terminal 2: `yarn --cwd src-vue serve`

### Production

To build a Fat-JAR for production just execute `./gradlew build` or `gradle build` when gradle is installed locally.
This will include the `yarn build` of the VueJS project. The built page then will be served by Ktor in production.

#### TL;DR Building:

In root directory of project execute:

- Terminal: `./gradlew build`

### Tools

- Ktor
- VueJS
- Gradle
- Yarn