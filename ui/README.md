# HackathonUi

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 16.2.2.

## Development NOTICE:

Currently importing and using **BootStrapCSS**. If removing this library, please also to remember to remove the imports from the `scripts` and `styles` array in `angular.json`.

## PWA (Progressive Web App) Important Notice:

For development, PWA features of this application are only enable when served from `localhost`

For deployment, the application must be delivered via **HTTPS** with a valid Cert to enable service workers used to run the PWA.

### Offline Caching API Endpoint Data

> Note: a script is need to fetch all API endpoints either on app load or a user button press. So data for additional pages beyond the from page is available.

For Caching API Data and make it available offline, it must be added to the `"dataGroups"` array in `ngsw-config.json`. See example below.

Example:

```
// ngsw-config.json
{
  "$schema": "./node_modules/@angular/service-worker/config/schema.json",
  "index": "/index.html",
  "assetGroups": [ /* ... */],
  "dataGroups": [
    {
      "name": "catFacts",
      "urls": ["https://catfact.ninja"],
      "cacheConfig": {
        "strategy": "freshness",
        "maxSize": 100,
        "maxAge": "100d",
        "timeout": "10s"
      }
    },
    //...
  ]
}
```
> IMPORTANT NOTE!: The Url supplied is a parent URL, so all routes under that url will also be cached (example: `catfact.ninj/facts`, `catfact.ninja/fact`, and `catfact.ninja/breeds`), as well as any parameters. Neat!

>BUT, recommend separating limiting specific branches under different names balanced the cache sized (`maxSize`) for performance.

## Development server

> Note: PWA features are disabled due to live reload issue with Angular.

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `npm run build` (preferred) or `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running/Testing the PWA (With Service Worker)

Run `npm run build` to build the app, then: <br>
Run `npm run serve` to use _lite-server_ to serve the build. Navigate to `http://localhost:3000/`, if the browser does not automatically open up.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.
