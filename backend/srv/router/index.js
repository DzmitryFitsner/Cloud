"use strict";

module.exports = (app, server) => {
    app.use("/bag", require("./routes/bag")());
    app.use("/dest", require("./routes/dest")());
};
