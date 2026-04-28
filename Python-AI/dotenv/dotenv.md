Make sure .env file has some key & values

.env

DB_HOST=localhost
DB_PORT=5432
SECRET_KEY=mysecret

### ❌ Wrong
### PORT = 5000   # space issue
---

## 🔹 QUOTES (IMPORTANT)
NAME="John Doe"
PASSWORD='abc@123'

👉 Use quotes if:

Spaces
Special characters

```
from dotenv import load_dotenv
import os

load_dotenv()

db = os.getenv("DB_HOST")
```