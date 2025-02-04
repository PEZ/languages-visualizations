(ns pez.browser)

(defn share! [site text]
  (let [url (-> js/window .-location .-href)]
    (.open js/window (str (case site
                            :site/x "https://twitter.com/intent/tweet?text="
                            :site/linkedin "https://www.linkedin.com/shareArticle?mini=true&text=")
                          (js/encodeURIComponent text)
                          "&url="
                          (js/encodeURIComponent url)))))