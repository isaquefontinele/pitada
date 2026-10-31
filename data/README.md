# data

Versioned datasets bundled with Pitada. Every entry must cite at least one source.

| File | Schema | Contents |
|---|---|---|
| `densities.json` | `schema/densities.schema.json` | Grams per millilitre per ingredient |

Volumes in sources are converted with 1 US cup = 236.588 ml. Values are rounded to three decimals.

## Validate

CI validates every dataset against its schema. To run the same check locally (Node.js 18+):

```bash
./scripts/validate-data.sh
```
