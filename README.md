# PriceGuard 

PriceGuard is a **self-hosted crypto & stock price notification backend** built with Spring Boot.
Set price thresholds on assets and get notified when the market hits them.

## Navigation

- [Roadmap](#)
- [API Docs](#)
- [Report a bug](../../issues)

## Features

**Custom price alerts** — define upper/lower thresholds per asset and get notified on breach

**User account system** — each user manages their own watchlist and alert preferences

**REST API** — straightforward endpoints to create, update, and delete alerts programmatically

**PostgreSQL-backed** — persistent storage for users, assets, and alert configurations

## Deployment

### Tech stack

- **Spring Boot 4.0** powers the REST API
- **PostgreSQL** for persistent storage
- **Spring Security** for auth

### Requirements

- **JDK 25** (GraalVM recommended)
- **PostgreSQL** 18+
- **Spring boot** 4.0+
- **Maven** 3.9+


## License


Copyright (C) 2026 X44annie

This program is free software: you can redistribute it and/or modify
it under the terms of the **European Union Public Licence (EUPL)**, version 1.2 with **Additional AI Restriction Clause**.

This code and its contents are **NOT permitted** for use in AI/ML training datasets,
language model training, code generation models, or any AI-related technology —
whether commercial or non-commercial.

Any use of this repository's contents for AI training purposes is explicitly prohibited
by the author and constitutes a violation of the terms under which this code is shared.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
[European Union Public Licence](./LICENSE) for more details.