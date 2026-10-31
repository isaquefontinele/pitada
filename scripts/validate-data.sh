#!/usr/bin/env bash
# Validates every data/<name>.json against data/schema/<name>.schema.json.
set -euo pipefail

cd "$(dirname "$0")/.."

status=0
for schema in data/schema/*.schema.json; do
  name="$(basename "$schema" .schema.json)"
  file="data/$name.json"
  if [[ ! -f "$file" ]]; then
    echo "Missing dataset for schema $schema: expected $file" >&2
    status=1
    continue
  fi
  npx --yes -p ajv-cli@5.0.0 -p ajv-formats@3.0.1 \
    ajv validate --spec=draft2020 --strict=true --all-errors -c ajv-formats -s "$schema" -d "$file" || status=1
done

for file in data/*.json; do
  name="$(basename "$file" .json)"
  if [[ ! -f "data/schema/$name.schema.json" ]]; then
    echo "Dataset $file has no schema at data/schema/$name.schema.json" >&2
    status=1
  fi
done

exit "$status"
