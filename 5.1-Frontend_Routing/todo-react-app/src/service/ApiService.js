import { API_BASE_URL } from "../api-config";

export function call(api, method, request) {
  let options = {
    headers: new Headers({
      "Content-Type": "application/json",
    }),
    url: API_BASE_URL + api,
    method: method,
  };
  if (request) {
    // GET method
    options.body = JSON.stringify(request);
  }
  return fetch(options.url, options).then((response) => {
    if (response.status === 200) {
      return response.json();
    } else if(response.status === 403) {
      window.location.href = "/login"; // redirect
    } else {
      new Error(response);
    }
  }).catch((error) => {
      console.log("http error");
      console.log(error);
    });
}
