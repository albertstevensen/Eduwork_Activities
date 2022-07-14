const url = 'http://zero.webappsecurity.com/index.html'
const searchbox = '#searchTerm'

class homepage{
    static visit(){
        cy.visit(url)
    }

    static searchbox(search){
        cy.get(searchbox).type(search)
    }
}

export default homepage