#dentsu-campaign-calculator

## Development environment (idea)

### Start db

Start docker with postgres `docker-compose up`.

### Start backend

Start spring boot project `App` with properties `-Dspring.profiles.active=dev -Dlogback.env=dev`.

### Start frontend

`cd static`

Setup `npm install -g @angular/cli`

Run `npm install`

Run `npm start` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.


### Start backend App

Start spring boot project `ru.smartvideossp.App` with properties `-Dspring.profiles.active=dev -Dlogback.env=dev`.
