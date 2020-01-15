const fs = require('fs');
const childproc = require('child_process');

if (fs.existsSync('../package.json')) {
    childproc.execSync('npm install && npm run build', {
        cwd: '..',
        stdio: 'inherit'
    });
}