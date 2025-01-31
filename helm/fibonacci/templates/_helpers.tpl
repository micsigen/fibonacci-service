{{/*
Create chart name and version as used by the chart label.
*/}}
{{- define "fibonacci.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" }}
{{- end }}

{{/*
Common labels
*/}}
{{- define "fibonacci.labels" -}}
helm.sh/chart: {{ include "fibonacci.name" . }}
app.kubernetes.io/name: {{ include "fibonacci.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}