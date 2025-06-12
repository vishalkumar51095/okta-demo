# 🔐 Okta Client Credentials Authentication – API Integration

This project demonstrates how to authenticate and authorize API requests using **Okta** and the **OAuth 2.0 Client Credentials Flow**, ideal for machine-to-machine communication.


## ✅ Prerequisites

Before proceeding, ensure:

- You have an [Okta Developer Account](https://developer.okta.com/).
- You created a **Service App** in Okta.
- You enabled the **`client_credentials` grant type**.
- You created an **Access Policy** and a **Rule** in your Authorization Server.
- You disabled **DPoP** if not using it (or implemented JWT Proof-of-Possession if needed).

## 🔑 Step 1: Generate Access Token

### 🔗 Endpoint

```http
POST https://dev-82404718.okta.com/oauth2/default/v1/token
````

### 🔐 Required Headers

```http
Content-Type: application/x-www-form-urlencoded
Authorization: Basic <Base64(client_id:client_secret)>
```

> Replace `<Base64(client_id:client_secret)>` with a Base64-encoded version of your `client_id:client_secret`.
> Example in Linux/macOS terminal:

```bash
echo -n 'your_client_id:your_client_secret' | base64
```

---

### 🧾 Example cURL Request

```bash
curl --location --request POST 'https://dev-82404718.okta.com/oauth2/default/v1/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Authorization: Basic MG9hcDU2ZW4zd2FoWkxvbGY1ZDc6cGQtNXNKNmtrUlFpR1E0TlptcnNUY1FfQjZRZUEwZ0V4MnZBLUNEWC1zaXBuS0hKZElZcGF0Q0tWcmc2RV9JVQ==' \
--data-urlencode 'grant_type=client_credentials' \
--data-urlencode 'scope=vishal'
```

---

### ✅ Successful Token Response

```json
{
  "token_type": "Bearer",
  "expires_in": 3600,
  "access_token": "eyJraWQiOiI5UzYwc00yX0JKTnhTMEU1bmhQX2FacjRUc1JCUGlIeG9EMlhLN3NPQlQwIiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULkI4QmRTNmMxSHg3dkxEbWtVczJEamExVXEwazhfUEVYdDNHckZJU05sY28iLCJpc3MiOiJodHRwczovL2Rldi04MjQwNDcxOC5va3RhLmNvbS9vYXV0aDIvZGVmYXVsdCIsImF1ZCI6ImFwaTovL2RlZmF1bHQiLCJpYXQiOjE3NDk3MTc2MzAsImV4cCI6MTc0OTcyMTIzMCwiY2lkIjoiMG9hcDU2ZW4zd2FoWkxvbGY1ZDciLCJzY3AiOlsidmlzaGFsIl0sInN1YiI6IjBvYXA1NmVuM3dhaFpMb2xmNWQ3In0.MSkxs-H3n6GX3nwba_bL2sqBDuMCV0pOlzSEe0Pu1OwW_F5Kzm_vEh-kcKAyufcbPY4KamwCqNLZyWy8DJio5_Dv3kOh8qS9Al-r-lemrWl92gd607tn59bmeqiuY_lmi-H2hvn8kXIQGZY8jKgjZcoQ8YN_2pm3cip0eZdzF05Ov9aXXQeBqyx0XZWt3o3TrrUtMWmFJg3WzQsbp_b4JScBv2FdE7QACi4xTJ0153tXJhirZUVsDILWSK-cKB7gWOs4Nazv9v4slm21ZTN5Ia0-uzUQMCsN__0f5W_RJAtpzt079BVgX6nRewfdBkPoXfR9Yqi-rw5AuIjn_asUWg",
  "scope": "vishal"
}
```

---

## 🔒 Step 2: Call Protected API using Access Token

Once you receive the token, use it in the `Authorization` header when making API requests.

### 🔗 Example cURL API Call

```bash
curl --request GET 'https://your-api.com/protected-endpoint' \
--header "Authorization: Bearer <access_token>"
```

Replace `<access_token>` with the token received in Step 1.

---

## 🧪 Step 3: Decode and Inspect the JWT (Optional)

To debug and inspect the token:

1. Go to [https://jwt.io](https://jwt.io)
2. Paste your `access_token` in the **Encoded** box
3. View claims like `iss`, `sub`, `exp`, `scope`, etc.

---

## 🔁 Token Information

| Property     | Value                                                               |
| ------------ | ------------------------------------------------------------------- |
| `token_type` | Bearer                                                              |
| `expires_in` | 3600 seconds (1 hour)                                               |
| `scope`      | vishal                                                              |
| `alg`        | RS256                                                               |
| `iss`        | [https://dev-82404718.okta.com/](https://dev-82404718.okta.com/)... |

---

## ❗ Common Errors & Fixes

| Error Code               | Description                      | Solution                                                   |
| ------------------------ | -------------------------------- | ---------------------------------------------------------- |
| `invalid_dpop_proof`     | Missing or invalid DPoP header   | Disable DPoP in app settings if not using it               |
| `access_denied`          | Policy evaluation failed         | Create proper access policy + rule in authorization server |
| `unsupported_grant_type` | `client_credentials` not allowed | Enable it in your app's grant types in Okta                |
| `invalid_client`         | Invalid client ID or secret      | Check credentials and Base64 encoding                      |

---

## 📚 Resources

* [Okta: Implement Client Credentials](https://developer.okta.com/docs/guides/implement-client-creds/)
* [JWT Debugger](https://jwt.io/)

---

## 👨‍💻 Author

**Vishal Kumar**
GitHub: [vishalkumar51095](https://github.com/vishalkumar51095)

---

````

---

### ✅ Next Steps

You can now:

1. Copy this into your project's `README.md`.
2. Commit it:
   ```bash
   git add README.md
   git commit -m "Added full Okta client_credentials auth documentation"
   git push origin main
````

Let me know if you want a PDF version or a `Postman` collection too!
