# dp-oppfolging

Oppretter oppfølgingsoppgaver i dp-saksbehandling når en person med aktiv dagpengeperiode mottar en sykmelding.

## Dataflyt

```
dp-andre-ytelser → teamdagpenger.rapid.v1 (annen_ytelse_endret, tema=SYM)
    → dp-oppfolging
        → dp-datadeling (sjekk dagpengeperioder)
        → dp-saksbehandling (opprett oppfølgingsoppgave)
```

## Bygg og test

```bash
./gradlew build
./gradlew test
./gradlew ktlintCheck
./gradlew ktlintFormat
```
