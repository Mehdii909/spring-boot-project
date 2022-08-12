import http from "k6/http";
import { group, check, sleep } from "k6";

const BASE_URL = "http://localhost:8080";
// Sleep duration between successive requests.
// You might want to edit the value of this variable or remove calls to the sleep function on the script.
const SLEEP_DURATION = 1;
// Global variables should be initialized.

export default function() {
    group("/saveProduit test", () => {

        let url = BASE_URL + `/saveProduit`;
        let body = JSON.stringify({
            nomProduit: 'ACER',
            prixProduit: 1500.50,
        });

        let request = http.post(url,body,{
            headers: {
                'Content-Type': 'application/json',
            },
        });
        check(request, {
            "Status should be 200": (r) => r.status === 200
        });
        sleep(SLEEP_DURATION);
    });

    group("/ListeProduits test", () => {

        let url = BASE_URL + `/ListeProduits`;

        let request = http.get(url);
        check(request, {
            "Status should be 200": (r) => r.status === 200
        });
        sleep(SLEEP_DURATION);
    });
}
