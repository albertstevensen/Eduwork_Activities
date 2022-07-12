/// <reference types="cypress" />

describe('Search Box Test', () =>{
    before(() =>{
        cy.visit('http://zero.webappsecurity.com/index.html')
        cy.url().should('include', 'index.html')
    });

    it('Should type into searchbox and submit', () =>{
       cy.get('#searchTerm').clear() 
       cy.get('#searchTerm').type('online {enter}') 
    });

    it('Should show search result page', () =>{
        cy.url().should('include', 'search.html?searchTerm=online')
        cy.get('h2').should('contain.text', 'Search Results:')
        cy.get('a').should('contain.text', 'Zero - Free Access to Online Banking')
        cy.get('a').should('contain.text', 'Zero - Online Statements')
    });
});