# Cognitive Processor

Eenvoudige Spring Boot REST-service die via Spring AI een lokaal Ollama-model aanspreekt en het gegenereerde antwoord retourneert met latency.

Het gebruikte model is **`adam`**, gebaseerd op **Llama 3 8B**, aangemaakt met een eigen Ollama *Modelfile*.

---

## Vereisten

* Java 17+
* Maven
* Ollama draaiend op `http://localhost:11434`
* Model `adam` beschikbaar in Ollama

---

## Starten

```bash
mvn spring-boot:run
```

Applicatie draait standaard op:

```
http://localhost:8080
```

---

## Endpoint

### `POST /ask` (http://localhost:8080/ask)

**Request**

```json
{
  "conversationId": "123"
  "message": "I see a person looking at me and smiling"
}
```

**Response**

```json
{
  "message": "I think: ... I do: ... I say: ...",
  "latency": 120,
  "timestamp": 1710000000000
}
```

De response bevat het modelantwoord, de verwerkingstijd (ms) en een timestamp.
