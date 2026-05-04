# dp-oppfolging — AI-kontekst

## Formål

`dp-oppfolging` er en Rapids & Rivers-app som oppretter oppfølgingsoppgaver
i dp-saksbehandling når en person med aktiv dagpengeperiode mottar en sykmelding.

## Arkitektur

```
dp-andre-ytelser → teamdagpenger.rapid.v1: "annen_ytelse_endret" (tema=SYM)
    → dp-oppfolging
        1. Hent aktivitet[].fom/tom fra hendelsen
        2. POST dp-datadeling /perioder (sjekk dagpengeperioder, kilde=DP_SAK)
        3. POST dp-saksbehandling /oppfolging (opprett oppgave)
```

## Integrasjoner

| System | Endpoint | Auth | Formål |
|--------|----------|------|--------|
| dp-datadeling | POST /dagpenger/datadeling/v1/perioder | Azure AD | Sjekk dagpengeperioder |
| dp-saksbehandling | POST /oppfolging | Azure AD | Opprett oppfølgingsoppgave |

## Konvensjoner

- **Mottakere heter `*Mottak`** ikke `*River` (team Dagpenger-konvensjon)
- **Logging av PII:** Full fnr kun i sikkerlogg (`tjenestekall`)
- **Kotlin JVM 21**, ktlint via `common` convention plugin

## Fil-struktur

```
src/main/kotlin/.../oppfolging/
├── App.kt                    # Entry point
├── Configuration.kt          # R&R defaults
└── (mottak og klienter kommer her)
```
