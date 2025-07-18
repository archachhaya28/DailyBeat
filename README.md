# DailyBeat
Simple app in Kotlin Multiplatform.

Daily Beat includes a native Android and a native iOS apps, where the business logic and inftrastructure is shared in a KMP module.

For now it has just two screens,

1. Articles screen which is fetching data locally
2. About Device screen to display informartion regarding the user's device

## Tech Stack
It is a prototype app based on the following technologies and patterns:

1. Clean Architecture
2. MVI
3. Jetpack Compose
4. Swift UI

The UI/Framework layers reside in the native apps, while everything from the View Model up to Data layer is in the common KMP module.


![Untitled Diagram drawio](https://github.com/petros-efthymiou/DailyPulse/assets/98778003/a1a465db-1484-4eb8-ab3c-1d43b457d7c2)

## Architectural Layers

<img width="531" alt="Screenshot 2023-12-04 at 18 19 53" src="https://github.com/petros-efthymiou/DailyPulse/assets/98778003/620fb7ca-68cb-428c-b134-4a012a8836eb">

